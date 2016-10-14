package Level.Tile;

import GameObject.Entity.Mob;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public class Tile {
	private final Sprite sprite;
	private final boolean IsSolid;
	public static Tile grass = new Tile(Sprite.GrassTile, false);

	public Tile(Sprite sp, boolean issolid) {
		sprite = sp;
		IsSolid = issolid;
	}

	public void Render(Screen screen, int x, int y) {
		screen.RenderTile(this, x * sprite.getWidth(), y * sprite.getHeight());
	}

	public boolean Collision(float xt, float yt, Mob mob) {
		if (mob.getX() >= xt && mob.getX() <= yt + getSprite().getWidth() && mob.getY() <= yt && mob.getY() >= yt + getSprite().getHeight())
			return true;
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean isIsSolid() {
		return IsSolid;
	}
}