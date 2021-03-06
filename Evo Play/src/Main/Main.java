package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Entity.Mob.Mob;
import Entity.Mob.MobHandler;
import Entity.Mob.Player;
import Graphics.Screen;
import Graphics.Sprite;
import GuiObject.InventoryObject.Items.InventoryItem;
import Level.RandomLevel;
import Input.KeyHandler;
import Input.MouseHandler;

public class Main extends Canvas implements Runnable {
	private JFrame Frame;
	private int[] Pixels;
	private Screen screen;
	private final Game game;
	public double VelX, VelY;
	private int keyTimer = 0;
	private final Thread main;
	private final String Title;
	private BufferedImage bimg;
	private boolean InUpgrades;
	private boolean InInventory;
	private final KeyHandler KH;
	private static Player player;
	private final MobHandler MOB;
	private final MouseHandler MH;
	private final RandomLevel level;
	private static final long serialVersionUID = 1L;
	private final static int Width = 800, Height = 600;

	public Main() {
		Title = "Title";
		main = new Thread(this);
		KH = new KeyHandler();
		MH = new MouseHandler();
		MOB = new MobHandler();
		level = new RandomLevel(45);
		game = new Game(KH, MH);
	}

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
		if (game.isRunning())
			return;
		game.setRunning(true);
		main.start();
	}

	public void run() {
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		int Frames = 0;
		int Updates = 0;
		final double NS = 1000000000.0 / 60;
		boolean Ticked = false;
		System.out.println("[System] Started");
		while (game.isRunning()) {
			long nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				game.Update();
				Update();
				Updates++;
				Ticked = true;
				Delta--;
			}
			if (Ticked) {
				Render();
				Ticked = false;
			}
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
		switch (Game_State) {
		case "Home":
			if (KH.Keys[0] && keyTimer == 0)
				Running = false;
			break;
		case "Options":
			if (KH.Keys[0] && keyTimer == 0) {
				Game_State = "Home";
				keyTimer++;
			}
			break;
		case "Choose Character":
			if (KH.Keys[0] && keyTimer == 0) {
				Game_State = "Home";
				keyTimer++;
			}
			break;
		case "Playing":
			if (!InInventory && !InUpgrades) {
				if (KH.Keys[1] || KH.Keys[7]) {
					VelY -= player.getSpeed();
					player.setDir(0);
					player.setIsMoving(true);
				} else if (KH.Keys[2] || KH.Keys[10]) {
					VelY += player.getSpeed();
					player.setDir(1);
					player.setIsMoving(true);
				} else if (KH.Keys[3] || KH.Keys[8]) {
					VelX -= player.getSpeed();
					player.setDir(2);
					player.setIsMoving(true);
				} else if (KH.Keys[4] || KH.Keys[9]) {
					VelX += player.getSpeed();
					player.setDir(3);
					player.setIsMoving(true);
				} else if (KH.Keys[12] && keyTimer == 0) {
					player.setExp(player.getExp() + 100);
					keyTimer++;
				} else if (KH.Keys[13] && player.getSpeed() > 0.6) {
					player.setSpeed(player.getSpeed() - 0.2);
				} else
					player.setIsMoving(false);
			}
			if (KH.Keys[0] && keyTimer == 0 && InInventory || KH.Keys[0] && keyTimer == 0 && InUpgrades) {
				if (InInventory)
					InInventory = false;
				if (InUpgrades)
					InUpgrades = false;
				MH.DestoryInventoryButtons();
				keyTimer++;
			}
			if (KH.Keys[11] && !InUpgrades && keyTimer == 0) {
				InUpgrades = true;
				for (int i = 0; i < 4; i++)
					MH.CreateUpgradeButtons(i);
				keyTimer++;
			}
			if (KH.Keys[11] && InUpgrades && keyTimer == 0) {
				InUpgrades = false;
				keyTimer++;
			}
			if (KH.Keys[6] && InInventory == true && keyTimer == 0) {
				InInventory = false;
				MH.DestoryInventoryButtons();
				keyTimer++;
			}
			if (KH.Keys[6] && keyTimer == 0) {
				int sn = 8;
				for (int i = 0; i < 8; i++)
					MH.CreateInventoryButton(i + 2, 8, i, true);
				for (int y = 0; y < 4; y++)
					for (int x = 0; x < 4; x++) {
						sn++;
						MH.CreateInventoryButton(x, y, sn, false);
					}
				InInventory = true;
				keyTimer++;
			}
			break;
		}
		if (keyTimer > 0 && keyTimer < 14)
			keyTimer++;
		else if (keyTimer > 0 && keyTimer >= 14)
			keyTimer = 0;

	}

	private void Update() {
		if (bimg != null)
			screen.Update((float) VelX, (float) VelY);
		switch (Game_State) {
		case "Playing":
			player.Update();
			screen.setOffset((int) (VelX), (int) (VelY));
			if (InInventory || InUpgrades) {
				MH.CheckIsHovered();
				if (InInventory)
					player.UpdateInventory(InInventory);
			}
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
			for (int i = 0; i < 9; i++)
				screen.RenderInventory1(player.getInventory(), i);
			if (InInventory) {
				for (int y = 0; y < 4; y++)
					for (int x = 0; x < 4; x++)
						screen.RenderInventorym(player.getInventory(), x, y);
				MH.RenderButtons(screen);
			}
			player.Render(screen, InInventory);
			if (InUpgrades) {
				screen.RenderUpgrade();
				for (int y = 0; y < 4; y++) {
					screen.RenderImage(736, (68 * y), 64, 64, Sprite.PlusButton);
				}
				MH.RenderButtons(screen);
			}
			g.drawImage(bimg, 0, 0, Width, Height, null);
			if (InUpgrades) {
				g.setColor(Color.white);
				g.drawString("EXP: " + player.getExp(), Width - 300, 340);
				g.drawString("Speed", 500, 45);
				g.drawString("Strength", 500, 120);
				g.drawString("Defense", 500, 195);
			}
			break;
		case "Home":
			screen.RenderBack();
			MH.RenderButtons(screen);
			g.drawImage(bimg, 0, 0, Width, Height, null);
			g.drawString("Single Player", 203, 215);
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

	public static void setPlayer(String Char) {
		switch (Char) {
		case "char1":
			player = new Player(Sprite.Human_F, '4');
			break;
		}
		setGS("Playing");
	}

	public static void slotselected(int sn) {
		boolean isinhand = false;
		int pastslot = 0;
		for (int i = 0; i < player.getInventory().length; i++) {
			if (player.getInventory()[i].isIsPicked() && player.getInventory()[i].getID() != "0") {
				pastslot = player.getInventory()[i].getSlotNum();
				player.getInventory()[sn] = new InventoryItem(sn, player.getInventory()[i].getID());
				if (pastslot != sn)
					player.getInventory()[i] = new InventoryItem(i, "0");
				isinhand = true;
				player.getInventory()[i].Init();
			}
			if (!isinhand && player.getInventory()[i].getID() != "0")
				player.getInventory()[sn].IsPicked();
		}
	}

	public static void getScrollamount(int scroll) {
		player.setNextF(scroll);
	}

	public static Mob getPlayer() {
		return player;
	}
}