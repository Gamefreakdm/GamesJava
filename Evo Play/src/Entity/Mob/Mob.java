package Entity.Mob;

import Entity.Entity;
import Graphics.Screen;

public abstract class Mob extends Entity {
	public void Move() {
		if (this.getDir() == 3)
			this.setX((float) (getX() + VelXN));
		if (this.getDir() == 3)
			this.setX((float) (getX() + VelXN));
		if (this.getDir() == 3)
			this.setX((float) (getX() + VelXN));
		if (this.getDir() == 3)
			this.setX((float) (getX() + VelXN));
	}

	public void Update() {
	}

	public void Render(Screen screen) {
	}
}