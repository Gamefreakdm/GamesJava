package Level;

import Graphics.Render.Screen;
import Level.Tile.Tile;

public class Level {
	private final int[] Tiles;
	private final int MapW, MapH;

	public Level(int w, int h) {
		MapW = w;
		MapH = h;
		Tiles = new int[w * h];
	}

	public Level(int s) {
		MapW = MapH = s;
		Tiles = new int[s * s];
	}

	public void Render(Screen screen, float xp, float yp) {
		Screen.setOffset(xp, yp);
		for (int y = 0; y < MapH; y++) {
			for (int x = 0; x < MapW; x++) {
				getTile(x, y).Render(screen, x, y);
			}
		}
	}

	public Tile getTile(int x, int y) {
		return null;
	}

	public int getMapW() {
		return MapW;
	}

	public int getMapH() {
		return MapH;
	}

	public int[] getTiles() {
		return Tiles;
	}
}