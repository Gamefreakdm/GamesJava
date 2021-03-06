package Graphics;

public class Screen {
	private int[] Pixels;
	private int Width, Height;

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
				Pixels[x + (y * Width)] = 0x0;
			}
		}
	}

	public void RenderPlayer(float f, float g, Sprite sp) {
		for (int y = 0; y < 32; y++) {
			int Ya = (int) (y + g);
			for (int x = 0; x < 32; x++) {
				int Xa = (int) (x + f);
				int col = sp.Pixels[x + (y * 32)];
				if (col != 0XFFFF00FF)
					Pixels[Xa + (Ya * Width)] = sp.Pixels[x + (y * 32)];
			}
		}
	}

	public void RenderBullet(float f, float g, Sprite sp) {
		for (int y = 0; y < 32; y++) {
			int Ya = (int) (y + g);
			for (int x = 0; x < 32; x++) {
				int Xa = (int) (x + f);
				int Col = sp.Pixels[x + (y * 32)];
				if (Col != 0XFFFF00FF)
					Pixels[Xa + (Ya * Width)] = sp.Pixels[x + (y * 32)];
			}
		}
	}

	public void RenderEnemy(float f, float g, Sprite sp) {
		for (int y = 0; y < 32; y++) {
			int Ya = (int) (y + g);
			if (Ya > Height || Ya < 0)
				continue;
			for (int x = 0; x < 32; x++) {
				int Xa = (int) (x + f);
				if (Xa > Width || Xa < 0)
					continue;
				int col = sp.Pixels[x + (y * 32)];
				if (col != 0XFFFF00FF)
					Pixels[Xa + (Ya * Width)] = sp.Pixels[x + (y * 32)];
			}
		}
	}

	public void DrawExlosion(float f, float g) {
		for (int y = 0; y < 32; y++) {
			int Ya = (int) (y + g);
			for (int x = 0; x < 32; x++) {
				int Xa = (int) (x + f);
				int Col = Sprite.Explosion.Pixels[x + (y * 32)];
				if (Col != 0XFFFF00FF) {
					Pixels[Xa + (Ya * Width)] = Sprite.Explosion.Pixels[x + (y * 32)];
				}
			}
		}
	}

	public void setWHP(int w, int h, int[] p) {
		Width = w;
		Height = h;
		Pixels = p;
	}

	public void setPixels(int[] p) {
		Pixels = p;
	}

	public int[] getPixels() {
		return Pixels;
	}
}
