package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Render.Screen;
import Input.InputHandler;

public class Main extends Canvas implements Runnable {
	private int[] Pixels;
	private Screen screen;
	private final Game game;
	private boolean Running;
	private final String Title;
	private final JFrame Frame;
	private BufferedImage bimg;
	private final InputHandler IH;
	private final int Width = 800, Height = 600;
	private static final long serialVersionUID = 1L;

	public Main() {
		System.out.println("[System] Starting...");
		Title = "Title";
		Frame = new JFrame("Loading...");
		game = new Game();
		IH = new InputHandler();
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.addMouseListener(M.IH);
		M.addMouseMotionListener(M.IH);
		M.Frame.add(M);
		M.Frame.addKeyListener(M.IH);
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
				game.Update(IH, Frame);
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
		game.Render(screen);
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