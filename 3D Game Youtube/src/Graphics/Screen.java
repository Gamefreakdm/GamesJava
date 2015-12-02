package Graphics;

public class Screen {
	private int[] Pixels;
	private int Width, Height;
	private int animTY = 0, animTX = 0;

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			if (Pixels[i] != 0)
				Pixels[i] = 0;
		}
	}

	public void Rendertest(float xoffset, float yoffset, int W, int H) {
		animTY++;
		animTX++;
		for (int y = 0; y < H; y++) {
			int ya = (int) (y + yoffset + animTY);
			if (ya < 0 || ya >= Height)
				break;
			for (int x = 0; x < W; x++) {
				int xa = (int) (x + xoffset + animTX);
				if (xa < 0 || xa >= Width)
					break;
				Pixels[xa + (ya * Width)] = 0x0FF00;
			}
		}
	}

	public void setWHP(int w, int h) {
		Width = w;
		Height = h;
	}

	public void setPixels(int[] p) {
		Pixels = p;
	}

	public int[] getPixels() {
		return Pixels;
	}
}
