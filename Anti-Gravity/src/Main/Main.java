package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Entity.Mob.Player;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;
import Main.Input.KeyHandler;
import Main.Input.MouseHandler;

public class Main extends Canvas implements Runnable {
	private Player player;
	private int[] Pixels;
	private int KeyTimer = 0;
	private Screen screen;
	private double BXP = 0;
	private boolean Running;
	private double BXP2 = 800;
	private final String Title;
	private final JFrame Frame;
	private BufferedImage bimg;
	private final KeyHandler KH;
	private final MouseHandler MH;
	private final int Width = 800, Height = 600;
	private static final long serialVersionUID = 1L;

	public Main() {
		System.out.println("[System] Starting...");
		Title = "Anti-Gravity";
		KH = new KeyHandler();
		MH = new MouseHandler();
		Frame = new JFrame("Loading...");
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.addMouseListener(M.MH);
		M.addMouseMotionListener(M.MH);
		M.Frame.add(M);
		M.Frame.addKeyListener(M.KH);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setVisible(true);
		M.Start();
	}

	private void Start() {
		if (Running)
			return;
		Thread thread = new Thread(this);
		thread.start();
		Running = true;
	}

	public void run() {
		int Frames = 0;
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
				Render();
				Frames++;
				Delta--;
			}
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		Stop();
	}

	private void KeyUpdate() {
		Frame.requestFocus();
		KH.Update();
		if (KH.Keys[0])
			Stop();
		if (KeyTimer == 0) {
			if (KH.Keys[1] && !player.getUp()) {
				player.Switch();
				KeyTimer++;
			}
			if (KH.Keys[2] && player.getUp()) {
				player.Switch();
				KeyTimer++;
			}
		} else {
			KeyTimer++;
			if (KeyTimer >= 14)
				KeyTimer = 0;
		}
	}

	private void Update() {
		KeyUpdate();
		if (BXP + 800 < 0)
			BXP = 800;
		BXP -= 1.5;
		if (BXP2 + 800 < 0)
			BXP2 = 800;
		BXP2 -= 1.5;
		if (player != null)
			player.Update();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(1);
			screen = new Screen(Width, Pixels);
			player = new Player(10, 200, Sprite.player_up);
			return;
		}
		screen.clearPixels();
		screen.RenderBack(BXP);
		screen.RenderBack(BXP2);
		screen.RenderPlayer(player.getX(), player.getY(), player.getSprite());
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		g.dispose();
		BS.show();
	}

	public void Stop() {
		System.out.println("[System] Stopping...");
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		if (Running)
			return;
		screen.clearPixels();
		Frame.dispose();
	}
}