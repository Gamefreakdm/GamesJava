package Level;

import Graphics.Screen;
import Level.Tile.Tile;

public class Level {
	protected int[] Tiles;
	protected final int mapSIZE;

	public Level(int ms) {
		mapSIZE = ms;
	}

	public void Render(float xscroll, float yscroll, String Map) {
		Screen.setOffset(xscroll, yscroll);
		for (int y = 0; y < mapSIZE; y++)
			for (int x = 0; x < mapSIZE; x++)
				getTile(x, y, Map).Render(x, y);
	}

	protected void generateLevel() {
	}

	public Tile getTile(int f, int g, String map) {
		switch (map) {
		case "Grass":
			if (f == 0 || g == 0 || g == mapSIZE - 1 || f == mapSIZE - 1)
				return Tile.RockWall;
			if (Tiles[(f + g * mapSIZE)] == 30)
				return Tile.blueFlower;
			if (Tiles[(f + g * mapSIZE)] == 2)
				return Tile.YellowFlower;
			return Tile.GrassFloor;
		case "Hell":
			if (f == 0 || g == 0 || g == mapSIZE - 1 || f == mapSIZE - 1)
				return Tile.HellWall;
			return Tile.HellFloor;
		case "Box":
			if (f == 0 || g == 0 || g == mapSIZE - 1 || f == mapSIZE - 1)
				return Tile.MetalWall;
			return Tile.MetalFloor;
		}
		return null;
	}

	public int[] getTiles() {
		return Tiles;
	}
}