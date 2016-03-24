package Level;

import java.util.Random;
import Graphics.Screen;
import Graphics.Sprite;

public class Level {
	private final int mapSize;
	private final int[] Tiles;

	public Level(int Size) {
		mapSize = Size*Size;
		Tiles = new int[Size * Size];
	}

	public void setLevel() {
		Random random = new Random();
		for (int i = 0; i < Tiles.length; i++) {
			Tiles[i] = random.nextInt(1000);
		}
	}

	public void Render(Screen screen) {
		for (int y = 0; y < screen.getHeight(); y++) {
			for (int x = 0; x < screen.getWidth(); x++) {
				getTile(x, y).Render(screen);
			}
		}
	}

	public Tile getTile(float x, int y) {
		if (Tiles[(int) (x + y * mapSize)] <= 1)
			return Tile.Star;
		return Tile.Black;
	}
}