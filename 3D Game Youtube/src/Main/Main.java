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
import Input.KeyHandler;

public class Main extends Canvas implements Runnable {
	private boolean Running;
	private final JFrame Frame;
	private BufferedImage bimg;
	public static Screen screen;
	private final KeyHandler KH;
	private final String Title;
	private final int Width, Height;
	private final Dimension screenSize;
	private static final long serialVersionUID = 1L;

	private Main() {
		System.out.println("[System] Starting...");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Width = (int) screenSize.getWidth();
		Height = (int) screenSize.getHeight();
		Title = "Pre-Alpha 1.0.1";
		KH = new KeyHandler();
		Frame = new JFrame("Loading...");
	}

	public static void main(String[] args) {
		Main M = new Main();
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
				Delta--;
			}
			Render();
			Frames++;
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
		if (KH.getKey(0))
			Running = false;
	}

	private void Update() {
		KeyUpdate();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			screen = new Screen(Width, Height);
			screen.setPixelsnew(((DataBufferInt) bimg.getRaster().getDataBuffer()).getData());
			createBufferStrategy(3);
			return;
		}
		if (Frame.getTitle() != "Loading...")
			screen.Render();
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		BS.show();
	}

	private void Stop() {
		if (Running)
			return;
		System.out.println("[System] Stopping...");
		CleanUp();
	}

	private void CleanUp() {
		screen.clearPixels();
		Frame.dispose();
	}
}