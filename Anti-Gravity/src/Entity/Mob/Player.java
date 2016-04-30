package Entity.Mob;

import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public class Player extends Mob {
	private boolean IsUp = true;

	public Player(float x, float y, Sprite sp) {
		super(x, y, sp);
	}

	public void Render(Screen screen) {
	}

	public void Update() {
		if (IsUp && this.getY() > 5)
			this.setY((float) (getY() - 1.5));
		else if (!IsUp && this.getY() + 32 < 568)
			this.setY((float) (getY() + 1.5));

	}

	public void Switch() {
		if (IsUp) {
			setSprite(Sprite.player_down);
			IsUp = false;
		} else {
			setSprite(Sprite.player_up);
			IsUp = true;
		}
	}

	public boolean getUp() {
		return IsUp;
	}
}