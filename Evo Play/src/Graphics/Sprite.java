package Graphics;

public class Sprite {
	protected int[] Pixels;
	public static Sprite GrassPlain_Floor = new Sprite(0, 0, SpriteSheet.Tiles, false, false);
	public static Sprite Grass_Floor = new Sprite(1, 0, SpriteSheet.Tiles, false, false);
	public static Sprite Water_Floor = new Sprite(2, 0, SpriteSheet.Tiles, false, false);
	public static Sprite Green_Glob = new Sprite(0, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Blue_Glob = new Sprite(1, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Red_Glob = new Sprite(2, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Yellow_Glob = new Sprite(3, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Human_R = new Sprite(4, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Human_L = new Sprite(4, 0, SpriteSheet.Chars1, true, false);
	public static Sprite Human_F = new Sprite(7, 0, SpriteSheet.Chars1, false, false);
	public static Sprite Select = new Sprite(3, 0, SpriteSheet.Tiles, false, false);

	public Sprite(int x, int y, SpriteSheet sheet, boolean xsf, boolean ysf) {
		Pixels = new int[64 * 64];
		Load(sheet, x << 6, y << 6, xsf, ysf);
	}

	public Sprite(int Col) {
		Pixels = new int[4096];
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = Col;
		}
	}

	private void Load(SpriteSheet sp, int X, int Y, boolean xsf, boolean ysf) {
		for (int y = 0; y < 64; y++) {
			int yf = 63 - y;
			for (int x = 0; x < 64; x++) {
				int xf = 63 - x;
				if (!xsf && !ysf)
					Pixels[x + y * 64] = sp.getPixels()[(x + X) + (y + Y) * 1024];
				else if (xsf && !ysf)
					Pixels[xf + y * 64] = sp.getPixels()[(x + X) + (y + Y) * 1024];
				else if (ysf && !xsf)
					Pixels[x + yf * 64] = sp.getPixels()[(x + X) + (y + Y) * 1024];
			}
		}
	}
}