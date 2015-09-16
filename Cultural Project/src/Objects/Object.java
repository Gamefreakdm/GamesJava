package Objects;

import Graphics.Sprite;

public class Object {
	protected int x, y;
	protected char Cart;
	protected Sprite sprite;

	public Object(int x, int y, char c, Sprite sp) {
		this.x = x;
		this.y = y;
		this.sprite = sp;
		this.Cart = c;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean CheckCol(int x, int y, int w, int h) {
		if (this.sprite != Sprite.Star) {
			if (this.getX() + 32 >= x && this.getX() <= x + w && this.getY() + 32 >= y && this.getY() <= y + h) {
				return true;
			}
		} else if (this.sprite != Sprite.Coin) {
			if (this.getX() + 32 >= x && this.getX() <= x + w && this.getY() + 32 >= y && this.getY() <= y + h) {
				return true;
			}
		} else {
			if (this.getX() + 32 >= x + 15 && this.getX() <= x + w - 15 && this.getY() + 32 >= y + 15 && this.getY() <= y + h - 15) {
				return true;
			}
		}
		return false;
	}
}