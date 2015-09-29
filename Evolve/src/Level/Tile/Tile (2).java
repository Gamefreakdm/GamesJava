package Level.Tile;

import Graphics.Sprite;

public class Tile {
	protected int x, y;
	protected Sprite sprite;
	public static Tile RockWall = new FloorTile(Sprite.RockWall);
	public static Tile HellWall = new WallTile(Sprite.HellFloor);
	public static Tile HellFloor = new FloorTile(Sprite.HellWall);
	public static Tile MetalWall = new WallTile(Sprite.MetalWall);
	public static Tile MetalFloor = new FloorTile(Sprite.MetalFloor);
	public static Tile GrassFloor = new FloorTile(Sprite.GrassFloor);
	public static Tile blueFlower = new FloorTile(Sprite.blueFlower);
	public static Tile YellowFlower = new FloorTile(Sprite.yellowFlower);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void Render(int x, int y) {
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