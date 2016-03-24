package Entity;

import Graphics.Screen;
import Graphics.Sprite;

public class Entity {
	private char car;
	private float x, y;
	private int Dir = 1;
	private Sprite sprite;
	protected boolean IsMoving;
	protected int animTimer = 0;
	@SuppressWarnings("unused")
	private final double VelXP = 2.0;
	@SuppressWarnings("unused")
	private final double VelYP = 2.0;
	@SuppressWarnings("unused")
	private final double VelXN = -2.0;
	@SuppressWarnings("unused")
	private final double VelYN = -2.0;

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

	public char getCar() {
		return car;
	}

	public void setCar(char car) {
		this.car = car;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}