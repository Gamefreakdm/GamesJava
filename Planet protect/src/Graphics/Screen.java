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
				Pixels[x + (y * Width)] = 0x0;
			}
		}
	}


	public static void RenderMain() {
		for (int y = 0; y < Height; y++) {
			for (int x = 0; x < Width; x++) {
				Pixels[x + (y * Width)] = 0x0ff00ff;
			}
		}
	}

	public static void RenderButton(int Y, int X, Sprite sp) {
		for (int y = 0; y < sp.getHS(); y++) {
			int Ya = y + Y;
			for (int x = 0; x < sp.getWS(); x++) {
				int Xa = x + X;
				System.out.println("sdfsdfsd");
				Pixels[Xa + (Ya * Width)] = sp.getPixels()[x + (y * 32)];
			}
		}
	}

	public static void RenderOptions() {
		for (int y = 0; y < Height; y++) {
			for (int x = 0; x < Width; x++) {
				Pixels[x + (y * Width)] = 0x000ff;
			}
		}
	}

	public static void setWHP(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}
}
