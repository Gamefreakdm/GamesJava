package Graphics;

public class Screen {
	private int[] Pixels;
	private final Render3D R3D;
	private final int Width, Height;

	public Screen(int w, int h) {
		this.Height = h;
		this.Width = w;
		R3D = new Render3D(getWidth(), getHeight(), this);
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
	}

	public void Render() {
		R3D.Floor();
	}

	public void setPixelsnew(int[] p) {
		Pixels = p;
	}

	public void setPixelsfull(int r, int e) {
		Pixels[r] = e;
	}

	private int getWidth() {
		return Width;
	}

	private int getHeight() {
		return Height;
	}
}
