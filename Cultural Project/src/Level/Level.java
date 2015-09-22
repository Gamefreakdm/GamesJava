package Level;

import java.util.LinkedList;
import Base.Main;
import Graphics.Screen;
import Graphics.Sprite;
import Objects.Object;

public class Level {
	public static int level = 0;
	private static LinkedList<Wall> Walls = new LinkedList<Wall>();
	private static LinkedList<Object> Objects = new LinkedList<Object>();

	public static void createLevel(int l) {
		Clean();
		level = l;
		Main.player.setX(10);
		Main.player.setY(Main.Height - 140);
		switch (level) {
		case 0:
			for (int i = 0; i < 8; i++) {
				Objects.add(new Object(i * 100, Main.Height - 100, 'c', Sprite.Coin));
			}
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 1:
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			Walls.add(new Wall(100, Main.Height - 120, 50, 10));
			Walls.add(new Wall(200, Main.Height - 140, 50, 10));
			Walls.add(new Wall(300, Main.Height - 170, 50, 10));
			Walls.add(new Wall(200, Main.Height - 230, 50, 10));
			Objects.add(new Object(210, Main.Height - 255, 'c', Sprite.Coin));
			break;
		case 2:
			Objects.add(new Object(130, Main.Height - 150, 'c', Sprite.Star));
			Objects.add(new Object(400, Main.Height - 100, 'c', Sprite.Star));
			Objects.add(new Object(265, Main.Height - 180, 'c', Sprite.Star));
			Walls.add(new Wall(100, Main.Height - 120, 50, 10));
			Walls.add(new Wall(200, Main.Height - 140, 50, 10));
			Walls.add(new Wall(300, Main.Height - 190, 50, 10));
			Objects.add(new Object(312, Main.Height - 212, 'c', Sprite.Coin));
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 4:
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		}
	}

	public static void UpdateLevel() {
		switch (level) {
		case 0:
			if (Main.Score == 8)
				Main.player.LevelUp(1);
			break;
		case 1:
			if (Main.Score == 9)
				Main.player.LevelUp(2);
			break;
		case 2:
			if (Main.Score == 10)
				Main.player.LevelUp(3);
			break;
		}
	}

	public static boolean WallCollision(int x, int y, int w, int h) {
		for (int c = 0; c < Walls.size(); c++) {
			if (Walls.get(c).CheckCol(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}

	public static boolean ObjectCollision(int x, int y, int w, int h) {
		for (int i = 0; i < Objects.size(); i++) {
			if (Objects.get(i).CheckCol(x, y, w, h)) {
				if (Objects.get(i).getSprite() == Sprite.Coin) {
					Objects.remove(i);
					Main.Score++;
				} else if (Objects.get(i).getSprite() == Sprite.Star) {
					Objects.remove(i);
					Main.player.setLives(Main.player.getLives() - 1);
				}
			}
		}
		return false;
	}

	public static void Render() {
		for (int i = 0; i < Walls.size(); i++) {
			Screen.RenderWall(Walls.get(i));
		}
		for (int i = 0; i < Objects.size(); i++) {
			Screen.RenderObjects(Objects.get(i));
		}
	}

	public static void Clean() {
		Objects.clear();
		Walls.clear();
	}
}