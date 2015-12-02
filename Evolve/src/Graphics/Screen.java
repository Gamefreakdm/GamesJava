package Graphics;

import Level.Tile.Tile;
import Main.Main;

public class Screen {
	private static float xOffset;
	private static float yOffset;

	public static void RenderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < -32 || xa >= Main.Width || ya < -32 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				Main.Pixels[xa + ya * Main.Width] = tile.getSprite().Pixels[x + y * 32];
			}
		}
	}

	public static void RenderPlayer(float xp, float yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + xp);
				if (xa < 0 || xa >= Main.Width || ya < 0 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 32];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = col;
			}
		}
	}

	public static void RenderEntity(float xp, float yp, Sprite sprite) {
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + xp);
				if (xa < 0 || xa >= Main.Width || ya < 0 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 32];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = col;
			}
		}
	}

	public static void setOffset(float xOf, float yOf) {
		xOffset = (int) xOf;
		yOffset = (int) yOf;
	}

	public static void Clear() {
		for (int i = 0; i < Main.Pixels.length; i++) {
			Main.Pixels[i] = 0;
		}
	}
}