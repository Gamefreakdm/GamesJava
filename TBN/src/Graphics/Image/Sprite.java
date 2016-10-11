package Graphics.Image;

public class Sprite {
	private final int[] Pixels;
	private final int Width, Height;

	public Sprite(int x, int y, int w, int h, SpriteSheet sheet) {
		Pixels = new int[w * h];
		Load(sheet, (x * w), (y * h), w, h);
		Width = w;
		Height = h;
	}

	public Sprite(int x, int y, int s, SpriteSheet sheet) {
		Pixels = new int[s * s];
		Load(sheet, x, y, s);
		Width = s;
		Height = s;
	}

	private void Load(SpriteSheet sp, int X, int Y, int w, int h) {
		for (int y = 0; y < h; y++)
			for (int x = 0; x < w; x++)
				Pixels[x + y * w] = sp.getPixels()[(x + X) + (y + Y) * sp.getWidth()];
	}

	private void Load(SpriteSheet sp, int X, int Y, int s) {
		for (int y = 0; y < s; y++)
			for (int x = 0; x < s; x++)
				Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getWidth()];
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