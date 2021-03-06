package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import Graphics.Screen;
import Objects.Enemy;
import Objects.ObjectList;
import Objects.Player;

public class Main extends Canvas implements Runnable {
	private boolean Running;
	private final JFrame Frame;
	private BufferedImage bimg;
	private final String Title;
	public static Player player;
	private static int Score = 0;
	private final int Width, Height;
	public static int HEight, WIdth;
	private final Dimension screenSize;
	private static Random random = new Random();
	private static final long serialVersionUID = 1L;
	private static KeyHandler KH = new KeyHandler();
	public static final Screen screen = new Screen();

	private Main() {
		System.out.println("[System] Starting...");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Width = (int) screenSize.getWidth();
		Height = (int) screenSize.getHeight();
		Title = "Space Invaders";
		Frame = new JFrame("Loading...");
		player = new Player(10, 0, KH);
		HEight = Height - 30;
		WIdth = Width - 30;
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(KH);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setVisible(true);
		M.Frame.pack();
		M.Start();
	}

	private void Start() {
		if (Running)
			return;
		Thread thread = new Thread(this);
		thread.start();
		Running = true;
		RestartGame();
	}

	public void run() {
		PlayMusic();
		int Frames = 0;
		int Updates = 0;
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		long nowTime = 0;
		final double NS = 1000000000.0 / 60;
		System.out.println("[System] Started");
		while (Running) {
			nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Update();
				Updates++;
				Delta--;
			}
			Render();
			Frames++;
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps" + "   |   " + Updates + " Updates");
				Frames = 0;
				Updates = 0;
			}
		}
		Stop();
	}

	private void KeyUpdate() {
		Frame.requestFocus();
		KH.Update();
		if (KH.Keys[1])
			Stop();
		if (KH.Keys[0])
			return;
	}

	@SuppressWarnings("static-access")
	private void PlayMusic() {
		try {
			AudioInputStream audioIn;
			Clip clip;
			clip = AudioSystem.getClip();
			audioIn = AudioSystem.getAudioInputStream(this.getClass().getResource("/Sounds/Main.wav"));
			clip.open(audioIn);
			clip.start();
			clip.loop(clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void ScoreUp() {
		try {
			AudioInputStream audioIn;
			Clip clip;
			clip = AudioSystem.getClip();
			audioIn = AudioSystem.getAudioInputStream(Main.class.getResource("/Sounds/Score.wav"));
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	private void Update() {
		KeyUpdate();
		player.Update();
		ObjectList.Update();
		ObjectList.CheckCol();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			screen.setPixels(((DataBufferInt) bimg.getRaster().getDataBuffer()).getData());
			createBufferStrategy(3);
			screen.setWHP(Width, Height, screen.getPixels());
			return;
		}
		screen.clearPixels();
		screen.Render();
		player.Render();
		ObjectList.Render();
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
		g.drawString("Score: " + Score, Width - 400, 60);
		g.drawString("Health: " + player.getHealth(), 0, 60);
		g.dispose();
		BS.show();
	}

	public static void RestartGame() {
		player = new Player(10, 200, KH);
		Score = 0;
		ObjectList.Removeall();
		for (int i = 0; i < 75; i++) {
			ObjectList.addEnemy(new Enemy(random.nextInt(400) * 2 + 500, random.nextInt(400) * 2));
		}
	}

	public void Stop() {
		if (!Running)
			System.exit(0);
		System.out.println("[System] Stopping...");
		CleanUp();
		Running = false;
	}

	private void CleanUp() {
		if (Running)
			return;
		screen.clearPixels();
		Frame.dispose();
	}

	public static void setScore(int s) {
		Score += s;
	}

	public static int getScore() {
		return Score;
	}
}