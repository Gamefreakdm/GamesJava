package Objects;

import Graphics.Sprite;

public class Object {
	protected float x, y;
	protected Sprite sprite;

	public Object(float x, float y, Sprite sp) {
		this.x = x;
		this.y = y;
		this.sprite = sp;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean CheckCol(float x, float y, float w, float h) {
		if (this.sprite == Sprite.Star) {
			if (this.getX() + 32 >= x + 7 && this.getX() <= x + w - 7 && this.getY() + 32 >= y + 15 && this.getY() <= y + h - 15) {
				return true;
			}
		} else if (this.sprite == Sprite.Coin) {
			if (this.getX() + 32 >= x + 15 && this.getX() <= x + w - 15 && this.getY() + 32 >= y && this.getY() <= y + h) {
				return true;
			}
		}
		return false;
	}
}