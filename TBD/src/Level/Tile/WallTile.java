package Level.Tile;

import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public class WallTile extends Tile {

	public WallTile(float sx, float sy, Sprite ssprite) {
		this.setIsSolid(true);
		this.setX(sx);
		this.setY(sy);
		this.setSprite(ssprite);
	}

	public void Update() {
	}

	public void Render(Screen screen) {
	}

	public void Collision() {
	}
}