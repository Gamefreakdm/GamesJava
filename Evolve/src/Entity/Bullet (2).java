package Entity;

import Graphics.Screen;
import Graphics.Sprite;

public class Bullet extends Entity {

	public Bullet(int x, int y, int Dir) {
		this.sprite = Sprite.Bullet;
		this.setX(x);
		this.setY(y);
		this.setDir(Dir);
	}

	public void Update() {
		switch (getDir()) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	public void Render() {
		Screen.RenderEntity(this.getX(), this.getY(), sprite);
	}
}