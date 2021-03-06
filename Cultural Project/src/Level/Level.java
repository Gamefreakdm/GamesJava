package Level;

import java.util.LinkedList;
import Base.Main;
import Graphics.Screen;
import Graphics.Sprite;
import Objects.Moving_Wall;
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
				Objects.add(new Object(i * 100, Main.Height - 100, Sprite.Coin));
			}
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 1:
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			Walls.add(new Wall(100, Main.Height - 120, 50, 10));
			Walls.add(new Wall(200, Main.Height - 140, 50, 10));
			Walls.add(new Wall(300, Main.Height - 170, 50, 10));
			Walls.add(new Wall(200, Main.Height - 210, 50, 10));
			Objects.add(new Object(210, Main.Height - 255, Sprite.Coin));
			break;
		case 2:
			Objects.add(new Object(130, Main.Height - 150, Sprite.Star));
			Objects.add(new Object(400, Main.Height - 100, Sprite.Star));
			Objects.add(new Object(265, Main.Height - 180, Sprite.Star));
			Walls.add(new Wall(100, Main.Height - 120, 50, 10));
			Walls.add(new Wall(200, Main.Height - 140, 50, 10));
			Walls.add(new Wall(300, Main.Height - 190, 50, 10));
			Objects.add(new Object(312, Main.Height - 212, Sprite.Coin));
			Objects.add(new Object(535, Main.Height - 250, Sprite.Coin));
			Objects.add(new Object(535, Main.Height - 300, Sprite.Coin));
			Objects.add(new Object(535, Main.Height - 200, Sprite.Coin));
			Walls.add(new Moving_Wall(500, Main.Height - 300, 100, 10, 'v', 2, 100));
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 3:
			Objects.add(new Object(95, Main.Height - 310, Sprite.Coin));
			Objects.add(new Object(350, Main.Height - 270, Sprite.Coin));
			Objects.add(new Object(228, Main.Height - 190, Sprite.Coin));
			Objects.add(new Object(160, Main.Height - 300, Sprite.Star));
			Walls.add(new Moving_Wall(160, Main.Height - 240, 100, 10, 'h', 2, 100));
			Walls.add(new Moving_Wall(60, Main.Height - 300, 100, 10, 'v', 2, 100));
			Walls.add(new Wall(370, Main.Height - 120, 100, 10));
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 4:
			Objects.add(new Object(350, Main.Height - 470, Sprite.Coin));
			Objects.add(new Object(400, Main.Height - 470, Sprite.Star));
			Objects.add(new Object(400, Main.Height - 400, Sprite.Coin));
			Objects.add(new Object(350, Main.Height - 400, Sprite.Star));
			Objects.add(new Object(350, Main.Height - 330, Sprite.Coin));
			Objects.add(new Object(400, Main.Height - 330, Sprite.Star));
			Objects.add(new Object(400, Main.Height - 260, Sprite.Coin));
			Objects.add(new Object(350, Main.Height - 260, Sprite.Star));
			Walls.add(new Wall(Main.Width - 50, Main.Height - 120, 50, 10));
			Walls.add(new Wall(Main.Width - 50, Main.Height - 220, 50, 10));
			Walls.add(new Wall(Main.Width - 150, Main.Height - 170, 50, 10));
			Walls.add(new Wall(Main.Width - 150, Main.Height - 270, 50, 10));
			Walls.add(new Wall(Main.Width - 300, Main.Height - 480, 50, 10));
			Walls.add(new Moving_Wall(Main.Width - 250, Main.Height - 450, 50, 10, 'v', 1.5, 90));
			Walls.add(new Wall(0, Main.Height - 120, 50, 10));
			Walls.add(new Wall(0, Main.Height - 220, 50, 10));
			Walls.add(new Wall(100, Main.Height - 170, 50, 10));
			Walls.add(new Wall(100, Main.Height - 270, 50, 10));
			Walls.add(new Wall(250, Main.Height - 480, 50, 10));
			Walls.add(new Moving_Wall(200, Main.Height - 450, 50, 10, 'v', 1.5, 90));
			Walls.add(new Wall(0, Main.Height - 68, Main.Width, 10));
			break;
		case 5:
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
			if (Main.Score == 13)
				Main.player.LevelUp(3);
			break;
		case 3:
			if (Main.Score == 16)
				Main.player.LevelUp(4);
			break;
		case 4:
			if (Main.Score == 20)
				Main.player.LevelUp(5);
			break;
		}
	}

	public static boolean WallCollision(float x, float y, int w, int h) {
		for (int c = 0; c < Walls.size(); c++) {
			if (Walls.get(c).CheckCol(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}

	public static boolean ObjectCollision(float x, float y, int w, int h) {
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

	public static void Update() {
		for (int i = 0; i < Walls.size(); i++) {
			Walls.get(i).Update();
		}
	}

	public static void Clean() {
		Objects.clear();
		Walls.clear();
	}
}