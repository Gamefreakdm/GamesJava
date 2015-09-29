package Entity.Mob;

import Entity.Entity;

public abstract class Mob extends Entity {
	protected boolean Moving = false;

	public void Move(int xa, int ya) {
		if (xa > 0)
			setDir(1);
		if (xa < 0)
			setDir(3);
		if (ya > 0)
			setDir(2);
		if (ya < 0)
			setDir(0);
		if (!Collision(xa, ya)) {
			setX((int) (getX() + xa));
			setY((int) (getY() + ya));
		}
	}

	public void Update() {
	}

	public void Render() {
	}

	private boolean Collision(int xa, int ya) {
		return false;
	}
}