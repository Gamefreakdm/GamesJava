package Entity.Mob;

import Entity.Entity;
import Graphics.Screen;

public abstract class Mob extends Entity {
	private double exp = 0;
	private double str = 0;
	private double def = 0;
	private float IHX = 0;
	private float IHY = 0;
	private double speed = 1.0;

	public void Update() {
	}

	public void Render(Screen screen) {
	}

	public void Anim() {
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double sp) {
		speed = sp;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public double getStr() {
		return str;
	}

	public void setStr(double str) {
		this.str = str;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public float getIHX() {
		return IHX;
	}

	public void setIHX(float iHX) {
		IHX = iHX;
	}

	public float getIHY() {
		return IHY;
	}

	public void setIHY(float iHY) {
		IHY = iHY;
	}
}