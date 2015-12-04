package Graphics;

public class Render {
	public int[] Pixels;
	private final int Width, Height;

	public Render(int w, int h) {
		Width = w;
		Height = h;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}
}