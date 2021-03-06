package Graphics;

public class Sprite {
	public int[] Pixels;
	public final int SIZE;
	public static Sprite Star = new Sprite(0, 0, 32, SpriteSheet.Main);
	public static Sprite Player_Still = new Sprite(1, 0, 32, SpriteSheet.Main);
	public static Sprite Player_Moving = new Sprite(2, 0, 32, SpriteSheet.Main);
	public static Sprite Enemy_Still = new Sprite(3, 0, 32, SpriteSheet.Main);
	public static Sprite Enemy_Moving = new Sprite(4, 0, 32, SpriteSheet.Main);
	public static Sprite Player_Bullet = new Sprite(5, 0, 32, SpriteSheet.Main);
	public static Sprite Enemy_Bullet = new Sprite(6, 0, 32, SpriteSheet.Main);
	public static Sprite Explosion = new Sprite(7, 0, 32, SpriteSheet.Main);

	public Sprite(int x, int y, int size, SpriteSheet sheet) {
		Pixels = new int[size * size];
		SIZE = size;
		Load(sheet, (x * size), (y * size), size);
	}

	private void Load(SpriteSheet sp, int X, int Y, int size) {
		if (SIZE == 32) {
			for (int y = 0; y < size; y++) {
				for (int x = 0; x < size; x++) {
					Pixels[x + y * size] = sp.getPixels()[(x + X) + (y + Y) * 256];
				}
			}
		} else {
			for (int y = 0; y < SIZE; y++) {
				for (int x = 0; x < SIZE; x++) {
					Pixels[x + y * SIZE] = sp.getPixels()[(x + X) + (y + Y) * 512];
				}
			}
		}
	}
}