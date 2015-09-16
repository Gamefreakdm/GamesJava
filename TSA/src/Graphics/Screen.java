package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import Main.ID;
import Main.Story;
import Objects.Object;
import Objects.ObjectsHandler;
import Objects.Player;
import Objects.Wall;

public class Screen {
	private ObjectsHandler OBH;
	public static Object Wall0;
	public static Object Wall1;
	public static Object Wall2;
	public static Object Wall3;
	public static Object Wall4;
	public static Object Wall5;
	public static Object Wall6;
	public static Object Wall7;
	public static Object Wall8;
	public static Object Wall9;
	public static Object Wall10;
	public static Object WinLine;
	public static Object player;
	public static int Cycle = 0;
	private final int WIDTH, HEIGHT;

	public Screen(int Width, int Height) {
		WIDTH = Width;
		HEIGHT = Height;
		OBH = new ObjectsHandler();
	}

	public final void Render(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		OBH.Render(g);
		g.setColor(Color.BLACK);
		g.drawString("Cycle: " + Cycle, 350, 290);
		if (Story.Storypart < 2 || Story.Storypart >= 4) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
	}

	public final void Update() {
		switch (Story.Storypart) {
		case 2:
			Wall0 = new Wall((short) 200, (short) 200, 400, 200, false, (byte) 4, ID.Wall0);
			Wall1 = new Wall((short) 0, (short) 0, 100, 400, false, (byte) 4, ID.Wall1);
			Wall2 = new Wall((short) 0, (short) 400, 100, 100, true, (byte) 1, ID.Wall2);
			Wall3 = new Wall((short) 0, (short) 500, 200, 100, false, (byte) 4, ID.Wall3);
			Wall4 = new Wall((short) 200, (short) 500, 200, 100, true, (byte) 3, ID.Wall4);
			Wall5 = new Wall((short) 400, (short) 500, 400, 100, false, (byte) 4, ID.Wall5);
			Wall6 = new Wall((short) 700, (short) 200, 100, 300, true, (byte) 0, ID.Wall6);
			Wall7 = new Wall((short) 700, (short) 200, 100, 300, true, (byte) 0, ID.Wall7);
			Wall8 = new Wall((short) 700, (short) 0, 100, 200, false, (byte) 0, ID.Wall8);
			Wall9 = new Wall((short) 100, (short) 0, 600, 100, false, (byte) 2, ID.Wall9);
			Wall10 = new Wall((short) 300, (short) 0, 100, 138, true, (byte) 2, ID.Wall10);
			WinLine = new Wall((short) 100, (short) 200, 100, 10, false, (byte) 4, ID.WinL);
			player = new Player((short) 110, (short) 110, 60, 60, ID.Player);
			OBH.addObject(player);
			OBH.addObject(Wall0);
			OBH.addObject(Wall1);
			OBH.addObject(Wall2);
			OBH.addObject(Wall3);
			OBH.addObject(Wall4);
			OBH.addObject(Wall5);
			OBH.addObject(Wall6);
			OBH.addObject(Wall7);
			OBH.addObject(Wall8);
			OBH.addObject(Wall9);
			OBH.addObject(Wall10);
			OBH.addObject(WinLine);
			Story.Storypart++;
			break;
		case 4:
			Wall0.setIsAlive(false);
			OBH.removeObject(Wall0);
			Wall1.setIsAlive(false);
			OBH.removeObject(Wall1);
			Wall2.setIsAlive(false);
			OBH.removeObject(Wall2);
			Wall3.setIsAlive(false);
			OBH.removeObject(Wall3);
			Wall4.setIsAlive(false);
			OBH.removeObject(Wall4);
			Wall5.setIsAlive(false);
			OBH.removeObject(Wall5);
			Wall6.setIsAlive(false);
			OBH.removeObject(Wall6);
			Wall7.setIsAlive(false);
			OBH.removeObject(Wall7);
			Wall8.setIsAlive(false);
			OBH.removeObject(Wall8);
			Wall9.setIsAlive(false);
			OBH.removeObject(Wall9);
			Wall10.setIsAlive(false);
			OBH.removeObject(Wall10);
			WinLine.setIsAlive(false);
			OBH.removeObject(WinLine);
			OBH.removeObject(player);
			Cycle = 0;
			Story.Storypart++;
			break;
		}
		OBH.Update();
	}
}