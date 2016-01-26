package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Entity.Mob.MobHandler;
import Entity.Mob.Player;
import Graphics.Screen;
import Graphics.Sprite;
import Level.RandomLevel;

public class Main extends Canvas {
	private JFrame Frame;
	@SuppressWarnings("unused")
	private Player player;
	private boolean Running;
	private int charnumx = 0;
	private int charnumy = 0;
	public double VelX, VelY;
	private int keyTimer = 0;
	public static int[] Pixels;
	private BufferedImage bimg;
	private BufferedImage back1;
	private Screen screen = new Screen();
	private final String Title = "Title";
	private MobHandler MH = new MobHandler();
	private final KeyHandler KH = new KeyHandler();
	private String Game_State = "Home";
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
		Running = true;
		getBack();
		Run();
	}

	private void getBack() {
		Random random = new Random();
		int back = random.nextInt(10);
		switch (back) {
		default:
			try {
				back1 = ImageIO.read(Main.class.getResource("/Textures/Back1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
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
		switch (Game_State) {
		case "Choose Character":
			if (keyTimer == 0) {
				if (KH.Left && charnumx > 0) {
					charnumx--;
					keyTimer = 1;
				}
				if (KH.Right && charnumx < 4) {
					charnumx++;
					keyTimer = 1;
					break;
				}
				if (KH.Up && charnumy > 0) {
					charnumy--;
					keyTimer = 1;
				}
				if (KH.Down && charnumy < 2) {
					charnumy++;
					keyTimer = 1;
					break;
				}
				if (KH.SPACE) {
					switch (charnumy) {
					case 0:
						switch (charnumx) {
						case 0:
							player = new Player(Sprite.Blue_Glob);
							break;
						case 1:
							player = new Player(Sprite.Green_Glob);
							break;
						case 2:
							player = new Player(Sprite.Yellow_Glob);
							break;
						case 3:
							player = new Player(Sprite.Red_Glob);
							break;
						case 4:
							player = new Player(Sprite.Human_F);
							break;
						}
						break;
					}
					keyTimer = 1;
					break;
				}
			} else {
				if (keyTimer >= 14)
					keyTimer = 0;
				else
					keyTimer++;
				break;
			}
			break;
		case "Playing":
			if (KH.Up)
				VelY -= 0.5;
			if (KH.Down)
				VelY += 0.5;
			if (KH.Left)
				VelX -= 0.5;
			if (KH.Right)
				VelX += 0.5;
			break;
		}
	}

	private void Update() {
		KeyUpdate();
		screen.Update((float) VelX, (float) VelY);
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
		Graphics g = BS.getDrawGraphics();
		switch (Game_State) {
		case "Choose Character":
			screen.Clear();
			screen.RenderCC(charnumx, charnumy);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			break;
		case "Playing":
			screen.Clear();
			level.Render((float) VelX, (float) VelY, "grass", screen);
			MH.Render(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			break;
		case "Home":
			g.drawImage(back1, 0, 0, Width, Height, null);
			break;
		}
		g.dispose();
		BS.show();
		g.clearRect(0, 0, Width, Height);
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