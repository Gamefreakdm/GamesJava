package Graphics;

public class Sprite {
	private final int SIZE;
	private final int[] Pixels;
	public static Sprite Plain = new Sprite(0, 0, 16, SpriteSheet.Tiles);
	public static Sprite Sky = new Sprite(1, 0, 16, SpriteSheet.Tiles);
	public static Sprite Rock = new Sprite(2, 0, 16, SpriteSheet.Tiles);

	public Sprite(int x, int y, int s, SpriteSheet sheet) {
		Pixels = new int[s * s];
		Load(sheet, (x * s), (y * s), s);
		SIZE = s;
	}

	private void Load(SpriteSheet sp, int X, int Y, int s) {
		for (int y = 0; y < s; y++)
			for (int x = 0; x < s; x++)
				Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
	}

	public int getSize() {
		return SIZE;
	}

	public int getdeSIZE() {
		return SIZE - 1;
	}

	public int[] getPixels() {
		return Pixels;
	}
}