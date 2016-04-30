package Graphics.Image;

public class Sprite {
	private final int SIZE;
	private final int[] Pixels;
	public static Sprite player_up = new Sprite(0, 0, 32, SpriteSheet.Chars, false, false);
	public static Sprite player_down = new Sprite(0, 0, 32, SpriteSheet.Chars, false, true);

	public Sprite(int x, int y, int s, SpriteSheet sheet, boolean xf, boolean yf) {
		Pixels = new int[s * s];
		Load(sheet, (x * s), (y * s), s, xf, yf);
		SIZE = s;
	}

	private void Load(SpriteSheet sp, int X, int Y, int s, boolean xf, boolean yf) {
		for (int y = 0; y < s; y++) {
			int yfs = (s - 1) - y;
			for (int x = 0; x < s; x++) {
				int xfs = (s - 1) - x;
				if (!xf && !yf)
					Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
				else if (xf && !yf)
					Pixels[xfs + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
				else if (yf && !xf)
					Pixels[x + yfs * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];

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