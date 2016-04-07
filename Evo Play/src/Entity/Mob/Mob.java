package Entity.Mob;

import Entity.Entity;
import Graphics.Screen;

public abstract class Mob extends Entity {
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
}