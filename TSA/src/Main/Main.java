package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import Graphics.Screen;

public class Main extends Canvas implements Runnable {
	private Screen screen;
	private boolean Running;
	private Thread mainthread;
	private final JFrame Frame;
	private final int WIDTH, HEIGHT;
	private static final long serialVersionUID = 1L;

	public Main() {
		Frame = new JFrame("Loading...");
		WIDTH = 800;
		HEIGHT = 600;
		screen = new Screen(WIDTH, HEIGHT);
	}

	public static void main(String[] args) {
		final Main M = new Main();
		final KeyHandler KH = new KeyHandler();
		M.Frame.add(M);
		M.Frame.addKeyListener(KH);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setSize(M.WIDTH, M.HEIGHT);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setVisible(true);
		M.Start();
	}

	private final void Start() {
		mainthread = new Thread(this);
		Running = true;
		if (!Running) {
			System.out.println("[System] Could not start! Boolean FALSE");
			System.exit(-1);
		} else
			mainthread.start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		long Timer = System.currentTimeMillis();
		final double NS = 1000000000.0 / 120.0;
		double Delta = 0;
		int Frames = 0;
		while (Running) {
			long nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Update();
				Frames++;
				Delta--;
			}
			if (System.currentTimeMillis() - Timer > 1000) {
				Timer += 1000;
				Frame.setTitle("Squared" + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		System.out.println("[System]Boolean stopped");
		System.exit(-1);
	}

	private final void Update() {
		Frame.requestFocus();
		Story.Update();
		screen.Update();
		Render();
	}

	private final void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		screen.Render(g);
		Story.Render(g);
		BS.show();
		g.dispose();
	}
}