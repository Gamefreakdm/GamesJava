package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Graphics.Image.AnimatedSprite;
import Graphics.Render.Screen;
import Input.KeyHandler;
import Input.MouseHandler;

public class Main extends Canvas implements Runnable {
	private int[] Pixels;
	private Screen screen;
	private boolean Running;
	private final String Title;
	private final JFrame Frame;
	private BufferedImage bimg;
	private final KeyHandler KH;
	private final MouseHandler MH;
	private final int Width = 800, Height = 600;
	private static final long serialVersionUID = 1L;

	public Main() {
		System.out.println("[System] Starting...");
		Title = "Cresit 0.0.1 Pre-Alpha";
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
		if (KH.Keys[0])
			Stop();
	}

	private void Update() {
		KeyUpdate();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(1);
			screen = new Screen(Width, Height, Pixels);
			return;
		}
		screen.clearPixels();
		screen.RenderSprite(AnimatedSprite.Player.getSprite(0), 20, 20);
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