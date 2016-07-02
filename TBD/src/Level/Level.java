package Level;

import java.util.Random;

import Graphics.Render.Screen;
import Level.Tile.Tile;

public class Level {
	private final int SIZE;
	private final int MapSIZE;
	private final int[] Tiles;
	private final int Swidth, Sheight;

	public Level(int s, char type, int sw, int sh) {
		SIZE = s;
		MapSIZE = s * s;
		Tiles = new int[MapSIZE];
		Swidth = sw;
		Sheight = sh;
		if (type == 'r')
			GenerateLevel();
		else if (type == 'a')
			LoadLevel(type);

	}

	public void Render(Screen screen) {
		for (int y = 0; y < SIZE; y++) {
			if (y > Sheight || y < 0)
				continue;
			for (int x = 0; x < SIZE; x++) {
				if (x > Swidth || x < 0)
					continue;
				getTile(x, y).Render(screen, x, y);
			}
		}
	}

	public void Update() {
	}

	public void LoadLevel(char t) {
	}

	public void GenerateLevel() {
		Random random = new Random();
		for (int y = 0; y < SIZE; y++) {
			if (y < 0 || y >= SIZE)
				continue;
			for (int x = 0; x < SIZE; x++) {
				if (x < 0 || x >= SIZE)
					continue;
				Tiles[x + (y * SIZE)] = random.nextInt(3);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (Tiles[x + (y * SIZE)] == 0)
			return Tile.Grass;
		return Tile.Grass;
	}

	public int getSIZE() {
		return SIZE;
	}
}