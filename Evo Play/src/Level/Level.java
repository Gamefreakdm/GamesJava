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
			for (int x = 0; x < mapSIZE; x++) {
				getRandomTile(x, y, this.mapSIZE).Render(x, y, screen);
			}
	}

	protected void generateLevel() {
	}

	public Tile getTile(int f, int g, String map) {
		return null;
	}

	private Tile getRandomTile(int x, int y, int mapSize) {
		if (this.Tiles[x + y * mapSize] >= 10 && this.Tiles[x + y * mapSize] <= 20)
			return Tile.Grass;
		if (this.Tiles[x + y * mapSize] < 2 || this.Tiles[x + y * mapSize] > 38)
			return Tile.Water_Floor;
		return Tile.GrassPlain;
	}

	public int[] getTiles() {
		return Tiles;
	}
}