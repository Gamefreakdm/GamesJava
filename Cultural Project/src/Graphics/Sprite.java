package Graphics;

public class Sprite {
	protected int[] Pixels;
	public static Sprite P1S = new Sprite(0, 0, SpriteSheet.Chars);
	public static Sprite P1SR = new Sprite(3, 0, SpriteSheet.Chars);
	public static Sprite P1MR = new Sprite(1, 0, SpriteSheet.Chars);
	public static Sprite P1ML = new Sprite(2, 0, SpriteSheet.Chars);
	public static Sprite P1SL = new Sprite(4, 0, SpriteSheet.Chars);
	public static Sprite Coin = new Sprite(0, 0, SpriteSheet.Objects);
	public static Sprite Star = new Sprite(1, 0, SpriteSheet.Objects);

	public Sprite(int x, int y, SpriteSheet sheet) {
		Pixels = new int[1024];
		Load(sheet, x << 5, y << 5);
	}

	private void Load(SpriteSheet sp, int X, int Y) {
		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < 32; x++) {
				Pixels[x + y * 32] = sp.getPixels()[(x + X) + (y + Y) * 256];
			}
		}
	}

	public int[] getPixels() {
		return Pixels;
	}
}