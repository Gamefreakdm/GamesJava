package GameObject.Mob;

import GameObject.Entity.Entity;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;;

public abstract class Mob extends Entity {
	private Sprite sprite;
	private final int SIZE;

	public Mob(float x, float y, int id, Sprite sprite) {
		this.setX(x);
		this.setY(y);
		this.setID(id);
		this.setSprite(sprite);
		this.SIZE = sprite.getSize();
	}

	public abstract void Update();

	public abstract void Render(Screen screen);

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public int getSIZE() {
		return SIZE;
	}
}