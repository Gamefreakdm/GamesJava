package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;
import Input.InputHandler;

public class Main extends Canvas implements Runnable {
	private Game game;
	private boolean Running;
	private int Width, Height;
	private final String Title;
	private final JFrame Frame;
	private BufferedImage bimg;
	public static Screen screen;
	private final InputHandler IH;
	private boolean Ticked = false;
	private static final long serialVersionUID = 1L;

	private Main() {
		System.out.println("[System] Starting...");
		Width = 800;
		Height = 600;
		Title = "Pre-Alpha 1.0.1";
		IH = new InputHandler();
		Frame = new JFrame("Loading...");
		game = new Game();
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(M.IH);
		M.addMouseListener(M.IH);
		M.addMouseMotionListener(M.IH);
		M.addMouseWheelListener(M.IH);
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
				Ticked = true;
				Delta--;
			}
			if (Ticked) {
				Render();
				Frames++;
				Ticked = false;
			}
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		Stop();
	}

	private void Update() {
		Frame.requestFocus();
		game.KeyUpdate(IH.Key);
		game.Update();
		if (!game.IsRunning())
			Running = false;
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			screen = new Screen(Width, Height);
			screen.setPixelsnew(((DataBufferInt) bimg.getRaster().getDataBuffer()).getData());
			createBufferStrategy(1);
			return;
		}
		screen.Render(game.getTime());
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		BS.show();
	}

	private void Stop() {
		System.out.println("[System] Stopping...");
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		screen.clearPixels();
		Frame.dispose();
	}
}