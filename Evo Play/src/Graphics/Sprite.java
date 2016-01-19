package Graphics;

public class Sprite {
	protected int[] Pixels;
	public static Sprite GrassPlain_Floor = new Sprite(0, 0, SpriteSheet.Tiles);
	public static Sprite Grass_Floor = new Sprite(1, 0, SpriteSheet.Tiles);
	public static Sprite Water_Floor = new Sprite(2, 0, SpriteSheet.Tiles);
	public static Sprite Green_Glob = new Sprite(0, 0, SpriteSheet.Chars1);
	public static Sprite Blue_Glob = new Sprite(1, 0, SpriteSheet.Chars1);
	public static Sprite Red_Glob = new Sprite(2, 0, SpriteSheet.Chars1);
	public static Sprite Yellow_Glob = new Sprite(3, 0, SpriteSheet.Chars1);

	public Sprite(int x, int y, SpriteSheet sheet) {
		Pixels = new int[64 * 64];
		Load(sheet, x << 6, y << 6);
	}

	public Sprite(int Col) {
		Pixels = new int[4096];
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = Col;
		}
	}

	public static void LoadSprites() {
	}

	private void Load(SpriteSheet sp, int X, int Y) {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++) {
				Pixels[x + y * 64] = sp.getPixels()[(x + X) + (y + Y) * 1024];
			}
		}
	}
}