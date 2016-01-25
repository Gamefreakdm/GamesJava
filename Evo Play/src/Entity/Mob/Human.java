package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;

public class Human extends Mob {

	public Human(float x, float y, int Level) {
		this.sprite = Sprite.Human_L;
	}

	public void Update() {
	}

	public void Render(Screen screen) {
		screen.RenderEntity(getX(), getY(), sprite);
	}
}
