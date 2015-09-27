package Graphics;

public class Sprite {
	public int[] Pixels;

	public Sprite(int x, int y, SpriteSheet sheet) {
		Pixels = new int[1024];
		Load(sheet, (x << 5), (y << 5));
	}

	private void Load(SpriteSheet sp, int X, int Y) {
		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < 32; x++) {
				Pixels[x + y * 32] = sp.getPixels()[(x + X) + (y + Y) * 256];
			}
		}
	}
}