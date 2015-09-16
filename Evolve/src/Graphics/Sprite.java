package Graphics;

public class Sprite {
	protected int[] Pixels;
	public static Sprite HellWall = new Sprite(0x880000);
	public static Sprite HellFloor = new Sprite(0x520000);
	public static Sprite MetalWall = new Sprite(0x808080);
	public static Sprite MetalFloor = new Sprite(0x212121);
	public static Sprite GrassFloor = new Sprite(0x1F7023);
	public static Sprite Bullet = new Sprite(0, 3, SpriteSheet.Chars1);
	public static Sprite RockWall = new Sprite(0, 0, SpriteSheet.Tiles);
	public static Sprite Enemy_AR1 = new Sprite(0, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR2 = new Sprite(1, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR3 = new Sprite(2, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR4 = new Sprite(3, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR5 = new Sprite(4, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR6 = new Sprite(5, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR7 = new Sprite(6, 0, SpriteSheet.Ems1);
	public static Sprite Enemy_AR8 = new Sprite(7, 0, SpriteSheet.Ems1);
	public static Sprite blueFlower = new Sprite(2, 0, SpriteSheet.Tiles);
	public static Sprite Player_FR1 = new Sprite(0, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR2 = new Sprite(1, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR3 = new Sprite(2, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR4 = new Sprite(3, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR5 = new Sprite(4, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR6 = new Sprite(5, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR7 = new Sprite(6, 1, SpriteSheet.Chars1);
	public static Sprite Player_FR8 = new Sprite(7, 1, SpriteSheet.Chars1);
	public static Sprite Player_GR1 = new Sprite(0, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR2 = new Sprite(1, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR3 = new Sprite(2, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR4 = new Sprite(3, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR5 = new Sprite(4, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR6 = new Sprite(5, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR7 = new Sprite(6, 2, SpriteSheet.Chars1);
	public static Sprite Player_GR8 = new Sprite(7, 2, SpriteSheet.Chars1);
	public static Sprite Player_SR1 = new Sprite(0, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR2 = new Sprite(1, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR3 = new Sprite(2, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR4 = new Sprite(3, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR5 = new Sprite(4, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR6 = new Sprite(5, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR7 = new Sprite(6, 0, SpriteSheet.Chars1);
	public static Sprite Player_SR8 = new Sprite(7, 0, SpriteSheet.Chars1);
	public static Sprite yellowFlower = new Sprite(1, 0, SpriteSheet.Tiles);

	public Sprite(int x, int y, SpriteSheet sheet) {
		Pixels = new int[1024];
		Load(sheet, x << 5, y << 5);
	}

	public Sprite(int Col) {
		Pixels = new int[1024];
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = Col;
		}
	}

	private void Load(SpriteSheet sp, int X, int Y) {
		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < 32; x++) {
				Pixels[x + y * 32] = sp.getPixels()[(x + X) + (y + Y) * 256];
			}
		}
	}
}