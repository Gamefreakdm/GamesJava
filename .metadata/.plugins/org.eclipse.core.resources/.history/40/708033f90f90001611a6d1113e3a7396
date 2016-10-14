package Level.Tile;

import GameObject.Entity.Mob;
import Graphics.Render.Screen;
import Graphics.Image.AnimatedSprite;
import Graphics.Image.Sprite;
import Main.Game;

public class AnimatedTile {
	private double PF = 0;
	private int Frame = 0;
	private Sprite sprite;
	private final Game game;
	private final double Ft;
	private final boolean IsSolid;
	private final AnimatedSprite sprites;

	public AnimatedTile(AnimatedSprite sps, boolean issolid, Game g, double FrameTime) {
		sprites = sps;
		sprite = sps.getSprite(0);
		IsSolid = issolid;
		game = g;
		Ft = FrameTime;
		PF = game.getTime();
	}

	public void Anim() {
		if (PF == game.getTime() - Ft) {
			if (Frame >= sprites.getSize())
				Frame = 0;
			Frame++;
			sprite = sprites.getSprite(Frame);
			PF = game.getTime();
		}
	}

	public void Render(Screen screen, float x, float y) {
		screen.RenderAnTile(this, x * sprite.getWidth(), y * sprite.getHeight());
	}

	public boolean Collision(float x, float y, Mob mob) {
		if (mob.getX() >= x && mob.getX() <= x + getSprite().getWidth() && mob.getY() <= y && mob.getY() >= y + getSprite().getHeight())
			return true;
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean isIsSolid() {
		return IsSolid;
	}

	public Game getGame() {
		return game;
	}

	public AnimatedSprite getSprites() {
		return sprites;
	}
}