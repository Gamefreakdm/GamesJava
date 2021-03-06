package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import Graphics.Sprite;
import javax.swing.JFrame;
import Entity.Mob.MobHandler;
import Entity.Mob.Player;
import Graphics.Screen;
import Level.Level;
import Level.RandomLevel;

public class Main extends Canvas {
	private JFrame Frame;
	private boolean Running;
	public static int[] Pixels;
	private BufferedImage bimg;
	private final String Title = "Title";
	private MobHandler MH = new MobHandler();
	private final KeyHandler KH = new KeyHandler();
	private static final long serialVersionUID = 1L;
	public static final int Width = 794, Height = 594;
	public static final Level level = new RandomLevel(45);
	private final Player player = new Player(400, 300, KH, "Farm");

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.Frame = new JFrame("Loading...");
		M.Frame.add(M);
		M.Frame.addKeyListener(M.KH);
		M.Frame.setSize(Width + 6, Height + 6);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setVisible(true);
		M.Start();
	}

	private void Start() {
		if (Running)
			return;
		Sprite.LoadSprites();
		Running = true;
		Run();
	}

	private void Run() {
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		int Frames = 0;
		int Updates = 0;
		final double NS = 1000000000.0 / 120;
		System.out.println("[System] Started");
		while (Running) {
			long nowTime = System.nanoTime();
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
		if (KH.ESC)
			Stop();
	}

	private void Update() {
		KeyUpdate();
		player.Update();
		MH.Update();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(1);
			if (MH.getListSize() == 0)
				for (int i = 0; i < 11; i++) {
					MH.addHappyPerson();
					MH.addSadPerson();
				}
			return;
		}
		Screen.Clear();
		level.Render((player.getX() - 365), (player.getY() - 265), "Grass");
		player.Render();
		if (MH.getListSize() != 0)
			MH.Render();
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		// MH.IsSpeaking(g);
		g.dispose();
		BS.show();
	}

	public void Stop() {
		if (!Running)
			System.exit(0);
		System.out.println("[System] Stopping...");
		Running = false;
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		Screen.Clear();
		Frame.dispose();
	}

	public static float getPlayerX() {
		Main M = new Main();
		return M.player.getX();
	}

	public static float getPlayerY() {
		Main M = new Main();
		return M.player.getY();
	}
}