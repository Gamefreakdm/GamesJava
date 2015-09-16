package Entity;

import Graphics.Sprite;
import Level.Level;

public class Entity {
	private int x, y;
	private int Dir = 1;
	private Level level;
	protected Sprite sprite;

	public void Update() {
	}

	public void Render() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
		return Dir;
	}

	public void setDir(int dir) {
		Dir = dir;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}