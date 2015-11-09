package Graphics;

public class Sprite {
	private int[] Pixels;
	private final int WS, HS;
	public static Sprite SPB = new Sprite(0, 0, 200, 200, SpriteSheet.Main);

	public Sprite(int x, int y, int ws, int hs, SpriteSheet sheet) {
		WS = ws;
		HS = hs;
		Pixels = new int[ws * hs];
		Load(sheet, (x << 5), (y << 5));
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

	public int getWS() {
		return WS;
	}

	public int getHS() {
		return HS;
	}
}