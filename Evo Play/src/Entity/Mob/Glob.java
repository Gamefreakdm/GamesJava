package Entity.Mob;

import java.util.Random;
import Graphics.Screen;
import Graphics.Sprite;

public class Glob extends Mob {

	public Glob(float x, float y, char Color) {
		switch (Color) {
		case 'g':
			this.sprite = Sprite.Green_Glob;
			break;
		case 'b':
			this.sprite = Sprite.Blue_Glob;
			break;
		case 'r':
			this.sprite = Sprite.Red_Glob;
			break;
		case 'y':
			this.sprite = Sprite.Yellow_Glob;
			break;
		}
		this.setX(x);
		this.setY(y);
	}

	public void Update() {
		AI();
	}

	public void Render(Screen screen) {
		screen.RenderEntity(getX(), getY(), sprite);
	}

	@SuppressWarnings("unused")
	private Sprite Animate() {
		return null;
	}

	private void AI() {
		if (ActTimer == 0) {
			ActTimer++;
			Random random = new Random();
			int vareint = random.nextInt(4);
			this.setDir(vareint);
		} else {
			ActTimer++;
			if (ActTimer >= 40)
				ActTimer = 1;
		}
	}
}