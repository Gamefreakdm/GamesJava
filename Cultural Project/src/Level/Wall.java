package Level;

import Base.Main;

public class Wall {
	protected int x, y, w, h;

	public Wall(int x, int y, int w, int h) {
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean CheckCol(int x, int y, int w, int h) {
		if (x + 27 >= this.getX() && x + 5 <= this.getX() + this.getWidth() && y + 32 >= this.getY() && y + 32 <= this.getY()) {
			System.out.println("col");
			Main.player.setGravity(false);
			return true;
		} else {
			Main.player.setGravity(true);
		}
		return false;
	}
}