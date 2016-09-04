package GameObject.Entity;

import java.util.Random;
import Graphics.Image.AnimatedSprite;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;
import Main.Game;

public abstract class Mob extends Entity {
	private Sprite sprite;
	private final Game game;
	private double pastTime;
	private final AnimatedSprite sprites;
	private boolean Up, Dow, Lef, Rig, mov;

	public Mob(int id, float x, float y, AnimatedSprite sps, Game g) {
		setID(id);
		setX(x);
		setY(y);
		sprites = sps;
		setSprite(sps.getSprite(0));
		game = g;
		pastTime = g.getTime();
	}

	public abstract void Update();

	public abstract void Render(Screen screen);

	public abstract void AI();

	public void AnimateSprite(int rate) {
		if (game.getTime() - pastTime >= game.getTime() - rate) {
			if (Up) {
				if (!mov) {
					setSprite(sprites.getSprite(2));
				} else {
					if (this.getSprite() == sprites.getSprite(0))
						setSprite(sprites.getSprite(1));
					else if (getSprite() == sprites.getSprite(1))
						setSprite(sprites.getSprite(0));
				}
			} else if (Dow) {
				if (!mov) {
					setSprite(sprites.getSprite(5));
				} else {
					if (this.getSprite() == sprites.getSprite(3))
						setSprite(sprites.getSprite(4));
					else if (getSprite() == sprites.getSprite(4))
						setSprite(sprites.getSprite(3));
				}
			} else if (Lef) {
				if (!mov) {
					setSprite(sprites.getSprite(8));
				} else {
					if (this.getSprite() == sprites.getSprite(6))
						setSprite(sprites.getSprite(7));
					else if (getSprite() == sprites.getSprite(7))
						setSprite(sprites.getSprite(6));
				}
			} else if (Rig) {
				if (!mov) {
					setSprite(sprites.getSprite(11));
				} else {
					if (this.getSprite() == sprites.getSprite(9))
						setSprite(sprites.getSprite(10));
					else if (getSprite() == sprites.getSprite(10))
						setSprite(sprites.getSprite(9));
				}
			}
		}
	}

	public boolean Collision(float x, float y, Mob mob) {
		if (x >= getX() && x <= getX() + getSprite().getWidth() && y <= getY() && y >= getY() + getSprite().getHeight())
			return true;
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public AnimatedSprite getSprites() {
		return sprites;
	}

	public Random getRand() {
		Random random = new Random();
		return random;
	}

	public Game getGame() {
		return game;
	}
}
