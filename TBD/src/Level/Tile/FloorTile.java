package Level.Tile;

import Graphics.Image.Sprite;
import Graphics.Render.Screen;

public class FloorTile extends Tile {

	public FloorTile(Sprite ssprite) {
		this.setIsSolid(false);
		this.setSprite(ssprite);
	}

	public void Update() {
	}

	public void Render(Screen screen, int sx, int sy) {
		screen.RT(getSprite(), sx << 5, sy << 5);
	}

	public void Collision() {
	}
}