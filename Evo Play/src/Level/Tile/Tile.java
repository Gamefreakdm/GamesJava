package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class Tile {
	private int x, y;
	protected Sprite sprite;
	public static FloorTile Grass = new FloorTile(Sprite.Grass_Floor1);
	public static FloorTile Water_Floor = new FloorTile(Sprite.Water_Floor1);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void Render(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean getIsSolid() {
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}