package Level;

import Graphics.Screen;
import Level.Tile.Tile;

public class Level {
	protected int[] Tiles;
	protected final int mapSIZE;

	public Level(int ms) {
		mapSIZE = ms;
	}

	public void Render(int xscroll, int yscroll, String Map) {
		Screen.setOffset(xscroll, yscroll);
		for (int y = 0; y < mapSIZE; y++)
			for (int x = 0; x < mapSIZE; x++)
				getTile(x, y, Map).Render(x, y);
	}

	protected void generateLevel() {
	}

	public Tile getTile(int x, int y, String map) {
		switch (map) {
		case "Grass":
			if (x == 0 || y == 0 || y == mapSIZE - 1 || x == mapSIZE - 1)
				return Tile.RockWall;
			if (Tiles[x + y * mapSIZE] == 30)
				return Tile.blueFlower;
			if (Tiles[x + y * mapSIZE] == 2)
				return Tile.YellowFlower;
			return Tile.GrassFloor;
		case "Hell":
			if (x == 0 || y == 0 || y == mapSIZE - 1 || x == mapSIZE - 1)
				return Tile.HellWall;
			return Tile.HellFloor;
		case "Box":
			if (x == 0 || y == 0 || y == mapSIZE - 1 || x == mapSIZE - 1)
				return Tile.MetalWall;
			return Tile.MetalFloor;
		}
		return null;
	}

	public int[] getTiles() {
		return Tiles;
	}
}