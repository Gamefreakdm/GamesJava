package Graphics;

public class Sprite {
	protected int[] Pixels;
	public static Sprite Paddle1 = new Sprite(0x00ff00ff);
	public static Sprite Ball = new Sprite(0, 0, SpriteSheet.Sp1);

	public Sprite(int x, int y, SpriteSheet sheet) {
		Pixels = new int[1024];
		Load(sheet, x << 5, y << 5);
	}

	public Sprite(int Col) {
		Pixels = new int[3520];
		for (int y = 0; y < 110; y++)
			for (int x = 0; x < 32; x++) {
				Pixels[x + y * 32] = Col;
			}
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