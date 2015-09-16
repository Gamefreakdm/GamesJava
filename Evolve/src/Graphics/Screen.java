package Graphics;

import Level.Tile.Tile;
import Main.Main;

public class Screen {
	private static int xOffset;
	private static int yOffset;

	public static void RenderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < -32 || xa >= Main.WIDTH || ya < -32 || ya >= Main.HEIGHT)
					break;
				if (xa < 0)
					xa = 0;
				if (ya < 0)
					ya = 0;
				Main.Pixels[xa + ya * Main.WIDTH] = tile.getSprite().Pixels[x + y * 32];
			}
		}
	}

	public static void RenderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= Main.WIDTH || ya < 0 || ya >= Main.HEIGHT)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 32];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.WIDTH] = col;
			}
		}
	}

	public static void RenderEntity(int xp, int yp, Sprite sprite) {
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= Main.WIDTH || ya < 0 || ya >= Main.HEIGHT)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 32];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.WIDTH] = col;
			}
		}
	}

	public static void setOffset(int xOf, int yOf) {
		xOffset = xOf;
		yOffset = yOf;
	}

	public static void Clear() {
		for (int i = 0; i < Main.Pixels.length; i++)
			Main.Pixels[i] = 0;
	}
}