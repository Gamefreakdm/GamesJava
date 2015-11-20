package Graphics;

public class Sprite {
	public int[] Pixels;
	public int Width, Height;
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
		Pixels = new int[4096];
		Load(sheet, (x << 6), (y << 6));
	}

	private void Load(SpriteSheet sp, int X, int Y) {
		int tw = 0;
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++) {
				int Col = sp.getPixels()[x + y * 1024];
				if (Col != 0XFFFF00FF)
					tw++;
				else {
					if (tw > Width)
						Width = tw;
					tw = 0;
				}
				Pixels[x + y * 64] = sp.getPixels()[(x + X) + (y + Y) * 1024];
			}
		}
	}
}