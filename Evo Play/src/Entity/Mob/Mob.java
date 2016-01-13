package Entity.Mob;

import Entity.Entity;
import Graphics.Screen;

public abstract class Mob extends Entity {
	public void Move(int xa, int ya) {
		if (xa > 0)
			setDir(1);
		if (xa < 0)
			setDir(3);
		if (ya > 0)
			setDir(2);
		if (ya < 0)
			setDir(0);
	}

	public void Update() {
	}

	public void Render(Screen screen) {
	}
}