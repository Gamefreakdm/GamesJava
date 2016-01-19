package Entity;

import Graphics.Screen;
import Graphics.Sprite;

public class Entity {
	private float x, y;
	private int Dir = 1;
	protected Sprite sprite;
	protected double VelXN = -0.5;
	protected double VelXP = 1.5;
	protected double VelYN = -1.5;
	protected double VelYP = 1.5;
	protected int ActTimer = 0;

	public void Update() {
	}

	public void Render(Screen screen) {
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