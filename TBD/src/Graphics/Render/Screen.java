package Graphics.Render;

import GameObject.Mob.Mob;
import Graphics.Image.Sprite;

public class Screen {
	private final int[] Pixels;
	private final int Width, Height;

	public Screen(int W, int H, int[] p) {
		Width = W;
		Height = H;
		Pixels = p;
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public void Render() {
		for (int y = 0; y < Height; y++)
			for (int x = 0; x < Width; x++)
				Pixels[x + (y * Width)] = 0x0;
	}

	public void RME(Mob mob) {
		for (int y = 0; y < mob.getSIZE(); y++)
			for (int x = 0; x < mob.getSIZE(); x++) {
				int xa = (int) mob.getX() + x;
				int ya = (int) mob.getY() + y;
				Pixels[xa + (ya * Width)] = mob.getSprite().getPixels()[x + (y * mob.getSprite().getSize())];
			}
	}

	public void RT(Sprite sprite, float sx, float sy) {
		for (int y = 0; y < sprite.getSize(); y++)
			for (int x = 0; x < sprite.getSize(); x++) {
				int xa = (int) sx + x;
				int ya = (int) sy + y;
				if (xa < 0 || xa >= Width || ya < 0 || ya >= Height)
					continue;
				Pixels[xa + (ya * Width)] = sprite.getPixels()[x + (y * sprite.getSize())];
			}
	}

	public int[] getPixels() {
		return Pixels;
	}
}
