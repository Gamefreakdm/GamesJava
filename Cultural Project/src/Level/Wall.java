package Level;

import Base.Main;

public class Wall {
	protected float x, y;
	protected int w, h;

	public Wall(float x, float y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void Update() {
	}

	public boolean CheckCol(float x, float y, int w, int h) {
		if (x + w - 5 >= this.getX() && x + 5 <= this.getX() + this.getWidth() && y + h >= this.getY() && y + h <= this.getY() + (this.getHeight() - 1)) {
			Main.player.setGravity(false);
			return true;
		} else if (y <= this.getY() + this.getHeight() && y >= this.getY() + this.getHeight() - this.getHeight() / 2 && x + w - 5 >= this.getX() + 1 && x + 5 <= this.getX() + this.getWidth()) {
			Main.player.setJumping(false);
			Main.player.setGravity(true);
			return true;
		}
		Main.player.setGravity(true);
		return false;
	}
}