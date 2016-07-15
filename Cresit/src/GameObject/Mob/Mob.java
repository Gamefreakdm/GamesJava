package GameObject.Mob;

import GameObject.Entity;
import Graphics.Image.AnimatedSprite;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public abstract class Mob extends Entity {
	private final AnimatedSprite sprites;
	private Sprite sprite;

	public Mob(int x, int y, int id, AnimatedSprite an) {
		sprites = an;
		setX(x);
		setY(y);
		setID(id);
	}

	public abstract void Update();

	public abstract void Render(Screen screen);

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public AnimatedSprite getSprites() {
		return sprites;
	}
}