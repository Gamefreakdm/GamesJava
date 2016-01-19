package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import Graphics.Sprite;
import javax.swing.JFrame;
import Entity.Mob.MobHandler;
import Graphics.Screen;
import Level.RandomLevel;

public class Main extends Canvas {
	private JFrame Frame;
	private boolean Running;
	public double VelX, VelY;
	public static int[] Pixels;
	private BufferedImage bimg;
	private Screen screen = new Screen();
	private final String Title = "Title";
	private MobHandler MH = new MobHandler();
	private final KeyHandler KH = new KeyHandler();
	private static final long serialVersionUID = 1L;
	public static final int Width = 800, Height = 600;
	public static final RandomLevel level = new RandomLevel(45);

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.Frame = new JFrame("Loading...");
		M.Frame.add(M);
		M.Frame.addKeyListener(M.KH);
		M.Frame.setSize(Width + 6, Height + 6);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setVisible(true);
		M.Start();
	}

	private void Start() {
		if (Running)
			return;
		Sprite.LoadSprites();
		Running = true;
		MH.addGlob(0, 0);
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
		if (KH.Up)
			VelY -= 0.5;
		if (KH.Down)
			VelY += 0.5;
		if (KH.Left)
			VelX -= 0.5;
		if (KH.Right)
			VelX += 0.5;
	}

	private void Update() {
		KeyUpdate();
		MH.Update();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(1);
			return;
		}
		screen.Clear();
		level.Render((float) VelX, (float) VelY, "grass", screen);
		MH.Render(screen);
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		g.dispose();
		BS.show();
	}

	public void Stop() {
		if (!Running)
			System.exit(0);
		System.out.println("[System] Stopping...");
		Running = false;
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		screen.Clear();
		Frame.dispose();
	}
}