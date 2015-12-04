package Graphics;

public class Screen extends Render {
	public int[] Pixels;
	private final Render3D R3D;

	public Screen(int w, int h) {
		super(w, h);
		R3D = new Render3D(w, h, Pixels);
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			if (Pixels[i] != 0)
				Pixels[i] = 0;
		}
	}

	public void Render() {
		R3D.Floor();
	}
}
