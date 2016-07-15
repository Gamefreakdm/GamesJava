package Graphics.Image;

public class Sprite {
	private final int SIZE;
	private final int[] Pixels;
	public static Sprite test = new Sprite(0, 0, 64, SpriteSheet.Chars);
	public static Sprite test1 = new Sprite(0, 0, 32, SpriteSheet.Tiles);

	public Sprite(int x, int y, int s, SpriteSheet sheet) {
		Pixels = new int[s * s];
		Load(sheet, (x * s), (y * s), s);
		SIZE = s;
	}

	private void Load(SpriteSheet sp, int X, int Y, int s) {
		for (int y = 0; y < s; y++)
			for (int x = 0; x < s; x++)
				Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getWidth()];
	}

	public int getSize() {
		return SIZE;
	}

	public int[] getPixels() {
		return Pixels;
	}
}