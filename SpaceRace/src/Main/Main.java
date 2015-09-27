package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;

public class Main extends Canvas {
	private JFrame Frame;
	private int[] Pixels;
	private KeyHandler KH;
	private boolean Running;
	private BufferedImage bimg;
	private String Title = "Title";
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 600;

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.KH = new KeyHandler();
		M.Frame = new JFrame("Loading...");
		M.Frame.add(M);
		M.Frame.addKeyListener(M.KH);
		M.Frame.setSize(WIDTH + 6, HEIGHT + 6);
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
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(3);
			return;
		}
		Screen.Render(Pixels);
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		BS.show();
	}

	public void Stop() {
		if (!Running)
			System.exit(0);
		System.out.println("[System] Stopping...");
		CleanUp();
		Running = false;
	}

	private void CleanUp() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
		Frame.dispose();
	}
}