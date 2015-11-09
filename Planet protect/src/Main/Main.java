package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Sprite;
import Graphics.Screen;
import Input.KeyHandler;

public class Main extends Canvas implements Runnable {
	private int[] Pixels;
	private boolean Running;
	@SuppressWarnings("unused")
	private char Game_State;
	private final JFrame Frame;
	private BufferedImage bimg;
	private final KeyHandler KH;
	private final int Width, Height;
	private final Dimension screenSize;
	private static final long serialVersionUID = 1L;
	private String Title = "Planet Protect Alpha 1.0.0";

	private Main() {
		System.out.println("[System] Starting...");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Width = (int) screenSize.getWidth();
		Height = (int) screenSize.getHeight();
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
		int Updates = 0;
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		long nowTime = 0;
		final double NS = 8333333.333333333;
		Game_State = 'M';
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
		if (!KH.Keys[0])
			return;
		if (KH.Keys[1])
			Stop();
		if (KH.Keys[2])
			Game_State = 'O';
		if (KH.Keys[3])
			Game_State = 'M';
	}

	private void Update() {
		KeyUpdate();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(3);
			Screen.setWHP(Width, Height, Pixels);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		Screen.Render();
		Screen.RenderButton(100, 100, Sprite.SPB);
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
		if (Running)
			return;
		Screen.clearPixels();
		Frame.dispose();
	}
}