package Graphics;

import Level.Tile.Tile;
import Main.Main;

public class Screen {
	private static float xOffset;
	private static float yOffset;

	public void RenderCC(int charnumx, int charnumy) {
		this.RenderEntity(40 + (160 * 0), 0, Sprite.Blue_Glob);
		this.RenderEntity(40 + (160 * 1), 0, Sprite.Green_Glob);
		this.RenderEntity(40 + (160 * 2), 0, Sprite.Yellow_Glob);
		this.RenderEntity(40 + (160 * 3), 0, Sprite.Red_Glob);
		this.RenderEntity(40 + (160 * 4), 0, Sprite.Human_F);
		this.RenderSelect(charnumx, charnumy);
	}

	public void RenderSelect(int charnumx, int charnumy) {
		int xp = 40 + (160 * charnumx);
		int yp = 0 + (100 * charnumy);
		for (int y = 0; y < 64; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 64; x++) {
				int xa = (int) (x + xp);
				if (xa < -64 || xa >= Main.Width || ya < -64 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = Sprite.Select.Pixels[x + y * 64];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = Sprite.Select.Pixels[x + y * 64];
			}
		}
	}

	public void RenderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 64; y++) {
			int ya = y + yp;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 64; x++) {
				int xa = x + xp;
				if (xa < -64 || xa >= Main.Width || ya < -64 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				Main.Pixels[xa + ya * Main.Width] = tile.getSprite().Pixels[x + y * 64];
			}
		}
	}

	public void Update(float xf, float yf) {
		this.setOffset(xf, yf);
	}

	public void RenderEntity(float xp, float yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 64; y++) {
			int ya = (int) (y + yp);
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < 64; x++) {
				int xa = (int) (x + xp);
				if (xa < -64 || xa >= Main.Width || ya < 0 || ya >= Main.Height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.Pixels[x + y * 64];
				if (col != 0XFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = col;
			}
		}
	}

	public void setOffset(float xOf, float yOf) {
		xOffset = (int) xOf;
		yOffset = (int) yOf;
	}

	public void Clear() {
		for (int i = 0; i < Main.Pixels.length; i++) {
			Main.Pixels[i] = 0;
		}
	}
}