package Base;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;
import Level.Level;
import Objects.Player;

public class Main extends Canvas implements Runnable {
	public static int[] Pixels;
	private BufferedImage BIMG;
	public static int Score = 0;
	private static boolean Running;
	private static KeyHandler KH = new KeyHandler();
	private static final long serialVersionUID = 1L;
	public static final int Width = 800, Height = 600;
	public static Player player = new Player(10, 10, 'x', KH);
	private final JFrame Frame = new JFrame("Loading...");
	private final String Title = "Artistic Representation  |  |  ";

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(KH);
		M.Frame.setResizable(false);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setSize(Width, Height);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setVisible(true);
		player.LevelUp(0);
		M.Start();
	}

	private void Start() {
		if (!Running) {
			Thread thread = new Thread(this);
			thread.start();
			Running = true;
			return;

		} else
			return;
	}

	public void run() {
		long Timer = System.currentTimeMillis();
		long LastTime = System.nanoTime();
		double Delta = 0;
		int Frames = 0;
		final double NS = 1000000000.0 / 60;
		System.out.println("[System] Started");
		while (Running) {
			long NowTime = System.nanoTime();
			Delta += ((NowTime - LastTime) / NS);
			LastTime = NowTime;
			while (Delta >= 1) {
				Render();
				Frames++;
				Update();
				Delta--;
			}
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + Frames + " FPS");
				Frames = 0;
			}
		}
		Stop();
	}

	private void Update() {
		KeyUpdate();
		player.Update();
		Level.UpdateLevel();
		Level.Update();
		Level.WallCollision(player.getX(), player.getY(), 32, 32);
		Level.ObjectCollision(player.getX(), player.getY(), 32, 32);
	}

	private void KeyUpdate() {
		Frame.requestFocus();
		KH.Update();
		if (KH.ESC)
			Stop();
		if (KH.L)
			player.LevelUp(4);
		if (Level.level == 3 && KH.ENTER) {
			player.setLives(3);
			player.LevelUp(4);
		}
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			BIMG = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) BIMG.getRaster().getDataBuffer()).getData();
			createBufferStrategy(3);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(BIMG, 0, 0, Width, Height, null);
		Screen.RenderBack();
		Level.Render();
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
		switch (Level.level) {
		case 0:
			g.drawString("Get The Coins", 150, 300);
			break;
		case 1:
			g.drawString("Get The Coin", 150, 300);
			break;
		case 2:
			g.drawString("Avoid The Stars", 115, 300);
			break;
		case 3:
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.drawString("Get the picture", 140, 150);
		case 4:
			break;
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Score: " + Score, 20, 20);
		g.drawString("Lives: " + player.getLives(), 200, 20);
		player.Render();
		BS.show();
		g.dispose();
	}

	public static void Stop() {
		if (!Running) {
			System.out.println("[System] Unknown Error!");
			System.exit(-1);
		} else {
			System.out.println("[System] Stopping...");
			Running = false;
			CleanUp();
		}
	}

	private static void CleanUp() {
		System.out.println("[System] Cleaning Up...");
		Main M = new Main();
		Screen.Clear();
		Level.Clean();
		M.Frame.dispose();
		System.exit(0);
	}
}