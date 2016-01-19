package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class WallTile extends Tile {

	public WallTile(Sprite sprite) {
		super(sprite);
	}

	public void Render(int x, int y, Screen screen) {
		screen.RenderTile(x << 6, y << 6, this);
	}

	public boolean getIsSolid() {
		System.out.println("Wall");
		return true;
	}
}