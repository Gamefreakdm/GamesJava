package Entity.Mob;

import Entity.Entity;
import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public abstract class Mob extends Entity {
	private Sprite sprite;

	public Mob(float x, float y, Sprite sp) {
		super(x, y);
		sprite = sp;
	}

	public abstract void Update();

	public abstract void Render(Screen screen);

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sp) {
		sprite = sp;
	}
}