package GameObject.Entity;

import java.util.Random;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;
import Main.Game;

public abstract class Item extends Entity {
	private final Game game;
	private final Sprite sprite;

	public Item(float x, float y, Sprite sp, Game g) {
		setX(x);
		setY(y);
		sprite = sp;
		game = g;
	}

	public abstract void Update();

	public abstract void Render(Screen screen);

	public boolean Collision(float x, float y, Mob mob) {
		if (x >= getX() && x <= getX() + getSprite().getWidth() && y <= getY() && y >= getY() + getSprite().getHeight())
			return true;
		return false;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Game getGame() {
		return game;
	}

	public Random getRand() {
		Random random = new Random();
		return random;
	}
}