package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class FloorTile extends Tile {

	public FloorTile(Sprite sprite) {
		super(sprite);
	}

	public void Render(int x, int y) {
		Screen.RenderTile(x << 5, y << 5, this);
	}

	public boolean getIsSolid() {
		System.out.println("Foor");
		return false;
	}
}