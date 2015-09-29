package Graphics;

public class Screen {
	private static int[] Pixels;
	private static int Width, Height;

	public static void clearPixels() {
		for (int i = 0; i < Pixels.length; i++)
			Pixels[i] = 0;
	}

	public static void Render() {
		for (int y = 0; y < Height; y++) {
			if (y < 0 || y >= Height)
				break;
			for (int x = 0; x < Width; x++) {
				if (x < 0 || x >= Width)
					break;
				Pixels[x + y * Width] = 0x0;
			}
		}
	}

	public static void RenderSp(float xp, float yp, Sprite sp) {
		for (int y = 0; y < sp.getSize(); y++) {
			int ya = (int) (y + yp);
			if (ya < 0 || ya >= Height)
				break;
			for (int x = 0; x < sp.getSize(); x++) {
				int xa = (int) (x + xp);
				if (xa < 0 || xa >= Width)
					break;
				Pixels[xa + ya * Width] = sp.Pixels[x + y * sp.getSize()];
			}
		}
	}

	public static void setWHP(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}
}