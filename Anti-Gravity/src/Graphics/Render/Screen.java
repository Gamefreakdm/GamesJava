package Graphics.Render;

import Graphics.Image.Image;
import Graphics.Image.Sprite;

public class Screen {
	private final int[] Pixels;
	private final int Width;

	public Screen(int W, int[] p) {
		Width = W;
		Pixels = p;
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public void RenderBack(double xp) {
		for (int y = 0; y < Image.SpaceBack.getHeight(); y++) {
			if (y < 0 || y >= Image.SpaceBack.getHeight())
				continue;
			for (int x = 0; x < Image.SpaceBack.getWidth(); x++) {
				int xa = (int) (xp + x);
				if (xa < 0 || xa >= Image.SpaceBack.getWidth())
					continue;
				Pixels[xa + (y * Width)] = Image.SpaceBack.getPixels()[x + y * 800];
			}
		}
	}

	public void RenderPlayer(float xp, float yp, Sprite sp) {
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + yp);
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + xp);
				int Col = sp.getPixels()[x + y * 32];
				if (Col != 0XFFFF00FF)
					Pixels[xa + ya * Width] = sp.getPixels()[x + y * 32];
			}
		}
	}

	public int[] getPixels() {
		return Pixels;
	}
}
