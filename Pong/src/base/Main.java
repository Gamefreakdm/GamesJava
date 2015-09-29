package base;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Graphics.Sprite;

public class Main extends Canvas implements Runnable {
	public static int[] Pixels;
	private BufferedImage BIMG;
	private static boolean Running;
	private final String Title = "Pong! | ";
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 600;
	private final JFrame Frame = new JFrame("Loading...");

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setSize(WIDTH, HEIGHT);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setVisible(true);
		Running = true;
		M.run();
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
				Update();
				Render();
				Frames++;
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
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			BIMG = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) BIMG.getRaster().getDataBuffer()).getData();
			createBufferStrategy(3);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(BIMG, 0, 0, WIDTH, HEIGHT, null);
		Screen.RenderBack();
		Screen.RenderBall(Sprite.Ball);
		BS.show();
		g.dispose();
	}

	public static void Stop() {
		if (!Running) {
			System.out.println("[System] Unknown Error!");
			System.exit(-1);
		} else {
			Running = false;
			CleanUp();
		}
	}

	private static void CleanUp() {
		Main M = new Main();
		Screen.Clear();
		M.Frame.dispose();
		System.exit(0);
	}
}