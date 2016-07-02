package Level.Tile;

import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public abstract class Tile {
	private Sprite sprite;
	private boolean IsSolid;
	public static Tile Grass = new FloorTile(Sprite.test1);

	public abstract void Update();

	public abstract void Render(Screen screen, int sx, int sy);

	public abstract void Collision();

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean isIsSolid() {
		return IsSolid;
	}

	public void setIsSolid(boolean isSolid) {
		IsSolid = isSolid;
	}
}