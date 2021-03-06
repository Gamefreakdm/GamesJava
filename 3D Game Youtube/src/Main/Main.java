package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;
import Input.InputHandler;

public class Main extends Canvas implements Runnable {
	private final Game game;
	private final JFrame Frame;
	private final String Title;
	private final InputHandler IH;
	private final Dimension screens;
	private final int Width, Height;
	private static final long serialVersionUID = 1L;

	private Main() {
		System.out.println("[System] Starting...");
		screens = Toolkit.getDefaultToolkit().getScreenSize();
		Width = screens.width;
		Height = screens.height;
		Frame = new JFrame("Loading...");
		game = new Game();
		Title = "Pre-Alpha 0.2.1";
		IH = new InputHandler(game);
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(M.IH);
		M.addMouseListener(M.IH);
		M.addMouseMotionListener(M.IH);
		M.addMouseWheelListener(M.IH);
		M.Frame.addFocusListener(M.IH);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setVisible(true);
		M.Start();
		System.out.println("[System] Finished Main.");
	}

	private void Start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		long nowTime = 0;
		final double NS = 1000000000.0 / 60;
		boolean Ticked = false;
		int Frames = 0;
		System.out.println("[System] Started.");
		while (game.IsRunning()) {
			nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Delta--;
			}
			Update();
			Ticked = true;
			if (Ticked) {
				Render();
				Frames++;
				Ticked = false;
			}
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + " | | " + Frames + " FPS");
				Frames = 0;
			}
		}
		Stop();
	}

	private void Update() {
		if (game.GameState() == "Playing")
			Frame.requestFocus();
		game.KeyUpdate(IH.Key, IH.getMxc(), IH.Istr());
		game.Update();
		if (game.GameState() == "Playing") {
		}
	}

	private int[] Pixels;
	private Screen screen;
	private BufferedImage bimg;

	private void Render() {
		final BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			screen = new Screen(Width, Height, game);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(1);
			System.out.println("[System] Created graphics.");
			return;
		}
		screen.Render();
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = screen.getPixels()[i];
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		BS.show();
	}

	private void Stop() {
		System.out.println("[System] Stopping...");
		CleanUp();
		System.out.println("[System] Stopped.");
		System.exit(0);
	}

	private void CleanUp() {
		screen.clearPixels();
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
		Frame.dispose();
		System.out.println("[System] Finished Clean Up.");
	}
}