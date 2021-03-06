package Objects;

import Graphics.Sprite;
import Main.Main;

public class Bullet extends Entity {
	private char GB;
	private Sprite sp;

	public Bullet(float f, float g, char gb) {
		GB = gb;
		setX(f);
		setY(g);
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
			if (this.getX() + this.getVel() > Main.WIdth) {
				ObjectList.removeBullet(this);
				return;
			}
			this.setVel(6.0);
			this.setX((int) (this.getX() + getVel()));
			break;
		case 'b':
			if (this.getX() - this.getVel() < 0) {
				ObjectList.removeBulletb(this);
				return;
			}
			this.setVel(4.0);
			this.setX((int) (this.getX() - getVel()));
			break;
		}
	}
}