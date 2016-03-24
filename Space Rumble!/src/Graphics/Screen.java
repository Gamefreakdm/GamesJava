package Graphics;

import Level.Tile;

public class Screen {
	private final int[] Pixels;
	private final int Width, Height;

	public Screen(int W, int H, int[] p) {
		Width = W;
		Height = H - 10;
		Pixels = p;
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public void Render() {
		for (int y = 0; y < Height; y++) {
			if (y < 0 || y >= Height)
				break;
			for (int x = 0; x < Width; x++) {
				if (x < 0 || x >= Width)
					break;
				Pixels[x + (y * Width)] = 0x00ff00;
			}
		}
	}

	public void RenderTile(float xp, float yp, Tile tile) {
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + yp);
			if (ya < 0 || ya >= 32)
				break;
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + xp);
				if (xa < 0 || xa >= 32)
					break;
				Pixels[xa + ya * Width] = tile.getSprite().getPixels()[x + y * tile.getSprite().getSize()];
			}
		}
	}

	public int[] getPixels() {
		return Pixels;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}
}
