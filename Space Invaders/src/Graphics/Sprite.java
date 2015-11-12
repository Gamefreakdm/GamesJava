package Graphics;

public class Sprite {
	public int[] Pixels;
	public static Sprite Star = new Sprite(0, 0, SpriteSheet.Main);
	public static Sprite Player_Still = new Sprite(1, 0, SpriteSheet.Main);
	public static Sprite Player_Up = new Sprite(2, 0, SpriteSheet.Main);
	public static Sprite Player_Down = new Sprite(3, 0, SpriteSheet.Main);
	public static Sprite Enemy_Still = new Sprite(4, 0, SpriteSheet.Main);
	public static Sprite Enemy_Up = new Sprite(5, 0, SpriteSheet.Main);
	public static Sprite Enemy_Down = new Sprite(6, 0, SpriteSheet.Main);
	public static Sprite Player_Bullet = new Sprite(7, 0, SpriteSheet.Main);
	public static Sprite Enemy_Bullet = new Sprite(0, 1, SpriteSheet.Main);
	public static Sprite Explosion = new Sprite(1, 1, SpriteSheet.Main);

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