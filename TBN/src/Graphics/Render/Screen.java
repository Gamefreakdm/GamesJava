package Graphics.Render;

import Graphics.Image.Sprite;
import Level.Tile.AnimatedTile;
import Level.Tile.Tile;

public class Screen {
	private int[] Pixels;
	private int Width, Height;
	private static float xOffset;
	private static float yOffset;

	public Screen(int W, int H, int[] p) {
		Width = W;
		Height = H;
		Pixels = p;
	}

	public void UpdateSize(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}

	public void RenderSprite(Sprite sp, float xp, float yp) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sp.getHeight(); y++) {
			int ya = (int) (y + yp);
			if (ya >= Height)
				continue;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < sp.getWidth(); x++) {
				int xa = (int) (x + xp);
				if (xa >= Width)
					continue;
				if (xa < 0)
					xa = 0;
				int Col = sp.getPixels()[x + (y * sp.getWidth())];
				if (Col != 0XFFFF00FF)
					Pixels[xa + (ya * Width)] = sp.getPixels()[x + (y * sp.getWidth())];
			}
		}
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public void RenderTile(Tile t, float xp, float yp) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < t.getSprite().getHeight(); y++) {
			int ya = (int) (y + yp);
			if (ya >= Height)
				continue;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < t.getSprite().getWidth(); x++) {
				int xa = (int) (x + xp);
				if (xa >= Width)
					continue;
				if (xa < 0)
					xa = 0;
				int Col = t.getSprite().getPixels()[x + (y * t.getSprite().getWidth())];
				if (Col != 0XFFFF00FF)
					Pixels[xa + (ya * Width)] = t.getSprite().getPixels()[x + (y * t.getSprite().getWidth())];
			}
		}
	}

	public void RenderATile(AnimatedTile ant, float xp, float yp) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < ant.getSprite().getHeight(); y++) {
			int ya = (int) (y + yp);
			if (ya >= Height)
				continue;
			if (ya < 0)
				ya = 0;
			for (int x = 0; x < ant.getSprite().getWidth(); x++) {
				int xa = (int) (x + xp);
				if (xa >= Width)
					continue;
				if (xa < 0)
					xa = 0;
				int Col = ant.getSprite().getPixels()[x + (y * ant.getSprite().getWidth())];
				if (Col != 0XFFFF00FF)
					Pixels[xa + (ya * Width)] = ant.getSprite().getPixels()[x + (y * ant.getSprite().getWidth())];
			}
		}
	}

	public static void setOffset(float xOf, float yOf) {
		xOffset = (int) xOf;
		yOffset = (int) yOf;
	}

	public int[] getPixels() {
		return Pixels;
	}
}