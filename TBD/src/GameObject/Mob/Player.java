package GameObject.Mob;

import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public class Player extends Mob {

	public Player(float x, float y, int id, Sprite sprite) {
		super(x, y, id, sprite);
	}

	public void Render(Screen screen) {
		screen.RME(this);
	}

	public void Update() {
	}
}