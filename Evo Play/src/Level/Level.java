package Level;

import Graphics.Screen;
import Level.Tile.Tile;

public class Level {
	protected int[] Tiles;
	protected final int mapSIZE;

	public Level(int ms) {
		mapSIZE = ms;
	}

	public void Render(float xscroll, float yscroll, String Map, Screen screen) {
		screen.setOffset(xscroll, yscroll);
		for (int y = 0; y < mapSIZE; y++)
			for (int x = 0; x < mapSIZE; x++)
				getRandomTile(x, y, this.mapSIZE).Render(x, y, screen);
	}

	protected void generateLevel() {
	}

	public Tile getTile(int f, int g, String map) {
		return null;
	}

	private Tile getRandomTile(int x, int y, int mapSize) {
		if (this.Tiles[x + y * mapSize] >= 1 && this.Tiles[x + y * mapSize] <= 4)
			return Tile.Grass;
		if (this.Tiles[x + y * mapSize] >= 5 && this.Tiles[x + y * mapSize] <= 7)
			return Tile.Grass;
		if (this.Tiles[x + y * mapSize] >= 8)
			return Tile.Grass;
		return Tile.Grass;
	}

	public int[] getTiles() {
		return Tiles;
	}
}