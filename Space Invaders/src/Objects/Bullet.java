package Objects;

import Graphics.Sprite;
import Main.Main;

public class Bullet extends Entity {
	protected char GB;
	protected Sprite sp;

	public Bullet(int x, int y, char gb) {
		GB = gb;
		setX(x);
		setY(y);
		switch (GB) {
		case 'g':
			sp = Sprite.Player_Bullet;
			break;
		case 'b':
			sp = Sprite.Enemy_Bullet;
			break;
		}
	}

	protected void Render() {
		Main.screen.RenderBullet(getX(), getY(), sp);
	}

	protected void Update() {
		switch (GB) {
		case 'g':
			if (this.getX() + this.getVel() > Main.WIdth)
				ObjectList.removeBullet(this);
			this.setVel(6.0);
			this.setX((int) (this.getX() + getVel()));
			break;
		case 'b':
			if (this.getX() - this.getVel() < 0)
				ObjectList.removeBulletb(this);
			this.setVel(4.0);
			this.setX((int) (this.getX() - getVel()));
			break;
		}
	}
}