package Graphics;

import Main.Game;

public class Render {
	public final Game game;
	protected final int[] Pixels;
	private final int Width, Height;

	public Render(int w, int h, Game g) {
		Width = w;
		Height = h;
		Pixels = new int[w * h];
		game = g;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}

	public int[] getPixels() {
		return Pixels;
	}
}