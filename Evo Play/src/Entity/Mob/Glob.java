package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;

public class Glob extends Mob {
	public Glob(float x, float y, char Color, int Level) {
		switch (Color) {
		case 'g':
			this.setSprite(Sprite.Green_Glob);
			break;
		case 'b':
			this.setSprite(Sprite.Blue_Glob);
			break;
		case 'r':
			this.setSprite(Sprite.Red_Glob);
			break;
		case 'y':
			this.setSprite(Sprite.Yellow_Glob);
			break;
		}
		this.setX(x);
		this.setY(y);
	}

	public void Update() {
	}

	public void Render(Screen screen) {
		screen.RenderEntity(getX(), getY(), getSprite());
	}

	@SuppressWarnings("unused")
	private Sprite Animate() {
		return null;
	}
}