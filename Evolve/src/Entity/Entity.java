package Entity;

import Graphics.Sprite;
import Level.Level;

public class Entity {
	private float x, y;
	private int Dir = 1;
	protected Sprite sprite;

	public void Update() {
	}

	public void Render() {
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getDir() {
		return Dir;
	}

	public void setDir(int dir) {
		Dir = dir;
	}
}