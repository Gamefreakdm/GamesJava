package Graphics;

public class Render {
	private final int SIZE;
	private final int[] Pixels;
	private final int Width, Height;

	public Render(int w, int h) {
		Width = w;
		Height = h;
		Pixels = new int[w * h];
		SIZE = 0;
	}

	public Render(int s) {
		SIZE = s;
		Width = s;
		Height = s;
		Pixels = new int[s * s];
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

	public int getSize() {
		return SIZE;
	}

	public int getdeSize() {
		return SIZE - 1;
	}

	protected void setPixels(int access, int result) {
		Pixels[access] = result;
	}
}