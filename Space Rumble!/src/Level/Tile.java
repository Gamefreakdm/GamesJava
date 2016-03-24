package Level;

import Graphics.Screen;
import Graphics.Sprite;

public class Tile {
	private float X, Y;
	private final Sprite sprite;
	public static Tile Black = new Tile(0, 0, Sprite.Black);
	public static Tile Star = new Tile(0, 0, Sprite.Star);

	public Tile(float x, float y, Sprite sp) {
		X = x;
		Y = y;
		sprite = sp;
	}

	public void Render(Screen screen) {
		screen.RenderTile(X, Y, this);
	}

	public void Update() {
	}

	public float getX() {
		return X;
	}

	public float getY() {
		return Y;
	}

	public Sprite getSprite() {
		return sprite;
	}
}