package Graphics;

public class Sprite {
	private final int SIZE;
	private final int[] Pixels;
	public static Sprite Black = new Sprite(0x0, 32);
	public static Sprite Star = new Sprite(0, 0, 32, SpriteSheet.Tiles);

	public Sprite(int x, int y, int s, SpriteSheet sheet) {
		Pixels = new int[s * s];
		Load(sheet, (x * s), (y * s), s);
		SIZE = s;
	}

	public Sprite(int Col, int Size) {
		this.SIZE = Size;
		Pixels = new int[Size * Size];
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = Col;
		}
	}

	private void Load(SpriteSheet sp, int X, int Y, int s) {
		for (int y = 0; y < s; y++) {
			for (int x = 0; x < s; x++) {
				Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
			}
		}
	}

	public int getSize() {
		return SIZE;
	}

	public int[] getPixels() {
		return Pixels;
	}
}