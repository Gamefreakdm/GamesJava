package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Entity.Mob.MobHandler;
import Entity.Mob.Player;
import Graphics.Screen;
import Graphics.Sprite;
import Level.RandomLevel;
import Main.Input.KeyHandler;
import Main.Input.MouseHandler;

public class Main extends Canvas implements Runnable {
	private JFrame Frame;
	private int[] Pixels;
	private Screen screen;
	private Thread main;
	private boolean Running;
	public double VelX, VelY;
	private int keyTimer = 0;
	private BufferedImage bimg;
	private boolean InInventory;
	private static Player player;
	private final String Title = "Title";
	private MobHandler MOB = new MobHandler();
	private static String Game_State = "Home";
	private static boolean IsFullscreen = false;
	private static int Width = 800, Height = 600;
	private final KeyHandler KH = new KeyHandler();
	private static final long serialVersionUID = 1L;
	private final MouseHandler MH = new MouseHandler();
	private final RandomLevel level = new RandomLevel(45);
	private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
		System.out.println("[System] Starting...");
		Main M = new Main();
		M.addMouseListener(M.MH);
		M.addMouseMotionListener(M.MH);
		M.addMouseWheelListener(M.MH);
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
		main = new Thread(this);
		main.start();
		MH.UpdateButtons(Game_State);
	}

	public void run() {
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		int Frames = 0;
		int Updates = 0;
		final double NS = 1000000000.0 / 60;
		System.out.println("[System] Started");
		while (Running) {
			long nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Update();
				Updates++;
				Render();
				Frames++;
				Delta--;
			}
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
		switch (Game_State) {
		case "Home":
			if (keyTimer == 0)
				if (KH.Keys[0])
					Running = false;
				else {
					if (keyTimer >= 14)
						keyTimer = 0;
					else
						keyTimer++;
					break;
				}
			break;
		case "Options":
			if (keyTimer == 0)
				if (KH.Keys[0]) {
					Game_State = "Home";
					keyTimer++;
				} else if (keyTimer >= 14)
					keyTimer = 0;
				else
					keyTimer++;
			break;
		case "Choose Character":
			if (keyTimer == 0)
				if (KH.Keys[0]) {
					Game_State = "Home";
					keyTimer = 1;
				} else {
					if (keyTimer >= 14)
						keyTimer = 0;
					else
						keyTimer++;
					break;
				}
			break;
		case "Playing":
			if (KH.Keys[1]) {
				VelY -= 0.9;
				player.setDir(0);
			} else if (KH.Keys[2]) {
				VelY += 0.9;
				player.setDir(1);
			} else if (KH.Keys[3]) {
				VelX -= 0.9;
				player.setDir(2);
			} else if (KH.Keys[4]) {
				VelX += 0.9;
				player.setDir(3);
			} else
				player.setDir(4);
			if (KH.Keys[0])
				InInventory = false;
			if (KH.Keys[6] && InInventory == true) {
				InInventory = false;
				keyTimer = 1;
			} else {
				if (keyTimer >= 14)
					keyTimer = 0;
				else
					keyTimer++;
			}
			if (KH.Keys[6] && InInventory == false) {
				for (int y = 0; y < 4; y++) {
					for (int x = 0; x < 4; x++) {
						MH.CreateInventoryButton(Width, Height, x, y);
					}
				}
				InInventory = true;
			}
			break;
		}
	}

	private void Update() {
		String pastgs = Game_State;
		KeyUpdate();
		MH.CheckIsHovered(MH.getX(), MH.getY());
		MH.UpdateButtons();
		if (Game_State != pastgs)
			MH.UpdateButtons(Game_State);
		if (bimg != null)
			screen.Update((float) VelX, (float) VelY);
		switch (Game_State) {
		case "Playing":
			player.Update();
			break;
		}
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			screen = new Screen(Width, Height, Pixels);
			createBufferStrategy(3);
			return;
		}
		Graphics g = BS.getDrawGraphics();
		if (IsFullscreen && Width == 800) {
			Frame.setVisible(false);
			Width = (int) screenSize.getWidth();
			Height = (int) screenSize.getHeight();
			Frame.setSize(Width, Height);
			MH.UpdateButtons(Game_State);
			Frame.setLocationRelativeTo(null);
			Frame.setVisible(true);
		} else if (!IsFullscreen && Width > 800) {
			Frame.setVisible(false);
			Width = 800;
			Height = 600;
			Frame.setSize(Width, Height);
			MH.UpdateButtons(Game_State);
			Frame.setLocationRelativeTo(null);
			Frame.setVisible(true);
		}
		for (int i = 0; i < screen.getPixels().length; i++)
			Pixels[i] = screen.getPixels()[i];
		g.setFont(new Font("", 40, 60));
		g.setColor(Color.blue);
		switch (Game_State) {
		case "Choose Character":
			screen.Clear();
			screen.RenderCC();
			MH.RenderButtons(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			break;
		case "Playing":
			screen.Clear();
			level.Render((float) VelX, (float) VelY, "grass", screen);
			MOB.Render(screen);
			for (int i = 0; i < 9; i++) {
				screen.RenderInventory1(player.getInventory(), i);
			}
			if (InInventory) {
				int Item = 8;
				for (int y = 0; y < 4; y++) {
					for (int x = 0; x < 4; x++) {
						screen.RenderInventorym(player.getInventory(), x, y);
					}
				}
			}
			player.Render(screen, InInventory);
			MH.RenderButtons(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			break;
		case "Home":
			screen.RenderBack();
			MH.RenderButtons(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			g.drawString("Single Player", getScreenOffsetpx() + 203, getScreenOffsetpy() + 215);
			g.drawString("Options", getScreenOffsetpx() + 275, getScreenOffsetpy() + 320);
			break;
		case "Options":
			screen.RenderBack();
			MH.RenderButtons(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			if (IsFullscreen)
				g.drawString("FullScreen: Off", getScreenOffsetpx() + 190, getScreenOffsetpy() + 220);
			else
				g.drawString("FullScreen: On", 190, 220);
			break;
		}
		g.dispose();
		BS.show();
	}

	public void Stop() {
		System.out.println("[System] Stopping...");
		Running = false;
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		screen.Clear();
		Frame.dispose();
	}

	public static void setFS() {
		if (IsFullscreen)
			IsFullscreen = false;
		else
			IsFullscreen = true;
	}

	public static void setGS(String gs) {
		Game_State = gs;
	}

	public static void setPlayer(String Char) {
		switch (Char) {
		case "char1":
			player = new Player(Sprite.Human_F, '4');
			break;
		}
		setGS("Playing");
	}

	public static int getScreenOffsetx() {
		if (IsFullscreen)
			return (Width - 800) / 2;
		return 0;
	}

	public static int getScreenOffsety() {
		if (IsFullscreen)
			return (Height - 620) / 2;
		return 0;
	}

	private int getScreenOffsetpx() {
		if (IsFullscreen)
			return (Width - 800) / 2;
		return 0;
	}

	private int getScreenOffsetpy() {
		if (IsFullscreen)
			return (Height - 601) / 2;
		return 0;
	}

	public static void getScrollamount(int scroll) {
		player.setNextF(scroll);
	}
}