package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;

public class Glob extends Mob {

	public Glob(float x, float y, char Color) {
		switch (Color) {
		case 'g':
			this.sprite = Sprite.Green_Glob;
		}
		this.setX(x);
		this.setY(y);
	}

	public void Update() {
	}

	public void Render(Screen screen) {
		screen.RenderEntity(getX(), getX(), sprite);
	}

	private Sprite Animate() {
		return null;
	}

	private void AI() {
	}
}