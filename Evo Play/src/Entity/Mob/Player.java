package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;

public class Player extends Mob {

	public Player(Sprite sprite, char c) {
		this.sprite = sprite;
		this.setX((800 / 2) - 30);
		this.setY((600 / 2) - 30);
		this.setCar(c);
	}

	public void Update() {
	}

	public void Render(Screen screen) {
		Anim();
		screen.RenderPlayer(getX(), getY(), sprite);
	}

	public void Anim() {
		switch (this.getCar()) {
		case '4':
			switch (this.getDir()) {
			case 0:
				this.sprite = Sprite.Human_B;
				break;
			case 1:
				this.sprite = Sprite.Human_F;
				break;
			case 2:
				this.sprite = Sprite.Human_L;
				break;
			case 3:
				this.sprite = Sprite.Human_R;
				break;
			}
			break;
		}
	}
}