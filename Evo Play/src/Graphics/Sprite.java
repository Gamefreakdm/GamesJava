package Graphics;

public class Sprite {
	protected int[] Pixels;
	protected final int SIZE;
	public static Sprite IHDSwordIIR = new Sprite(0, 0, SpriteSheet.InHandItems, 32, false, false);
	public static Sprite IHDSwordIIL = new Sprite(0, 0, SpriteSheet.InHandItems, 32, true, false);
	public static Sprite Grass_Floor1 = new Sprite(0, 0, SpriteSheet.Tiles2, 32, false, false);
	public static Sprite Water_Floor1 = new Sprite(3, 0, SpriteSheet.Tiles2, 32, false, false);
	public static Sprite Sword_II = new Sprite(3, 0, SpriteSheet.InventoryItems1, 64, false, false);
	public static Sprite InventorySlot = new Sprite(2, 0, SpriteSheet.InventoryItems1, 64, false, false);
	public static Sprite EmptySlot = new Sprite(0, 0, SpriteSheet.InventoryItems1, 64, false, false);
	public static Sprite InHand = new Sprite(1, 0, SpriteSheet.InventoryItems1, 64, false, false);
	public static Sprite Green_Glob = new Sprite(0, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Blue_Glob = new Sprite(1, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Red_Glob = new Sprite(2, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Yellow_Glob = new Sprite(3, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_R = new Sprite(4, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_RK = new Sprite(5, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_RS = new Sprite(6, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_LS = new Sprite(6, 0, SpriteSheet.Chars1, 64, true, false);
	public static Sprite Human_L = new Sprite(4, 0, SpriteSheet.Chars1, 64, true, false);
	public static Sprite Human_LK = new Sprite(5, 0, SpriteSheet.Chars1, 64, true, false);
	public static Sprite Human_F = new Sprite(8, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_FF = new Sprite(8, 0, SpriteSheet.Chars1, 64, true, false);
	public static Sprite Human_B = new Sprite(7, 0, SpriteSheet.Chars1, 64, false, false);
	public static Sprite Human_BF = new Sprite(7, 0, SpriteSheet.Chars1, 64, true, false);
	public static Sprite Select = new Sprite(0, 0, SpriteSheet.Tiles1, 64, false, false);
	public static Sprite PlusButton = new Sprite(4, 0, SpriteSheet.InventoryItems1, 64, false, false);

	public Sprite(int x, int y, SpriteSheet sheet, int size, boolean xsf, boolean ysf) {
		Pixels = new int[size * size];
		Load(sheet, x * size, y * size, size, xsf, ysf);
		SIZE = size;
	}

	public Sprite(int Col, int size) {
		Pixels = new int[size * size];
		SIZE = size;
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = Col;
	}

	private void Load(SpriteSheet sp, int X, int Y, int s, boolean xsf, boolean ysf) {
		for (int y = 0; y < s; y++) {
			int yf = (s - 1) - y;
			for (int x = 0; x < s; x++) {
				int xf = (s - 1) - x;
				if (!xsf && !ysf)
					Pixels[x + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
				else if (xsf && !ysf)
					Pixels[xf + y * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
				else if (ysf && !xsf)
					Pixels[x + yf * s] = sp.getPixels()[(x + X) + (y + Y) * sp.getSize()];
			}
		}
	}
}