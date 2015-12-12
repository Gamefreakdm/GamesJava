package Graphics;

public class Screen extends Render {
	private int[] Pixels;
	private final Render3D R3D;

	public Screen(int w, int h) {
		super(w, h);
		R3D = new Render3D(getWidth(), getHeight());
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
	}

	public void Render() {
		clearPixels();
		R3D.Floor();
	}

	public void setPixelsnew(int[] p) {
		Pixels = p;
	}

	public void setPixelsfull(int r, int e) {
		Pixels[r] = e;
	}
}
