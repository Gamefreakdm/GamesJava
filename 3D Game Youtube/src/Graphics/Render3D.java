package Graphics;

public class Render3D extends Render {
	private int[] Pixels;

	public Render3D(int w, int h, int[] p) {
		super(w, h);
		Pixels = p;
	}

	public void Floor() {
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = y - getHeight() / 2;
			double z = 100.0 / ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = x - getWidth() / 2;
				xdepth *= z;
				int xx = (int) xdepth;
				Pixels[x + (y * getWidth())] = xx;
			}
		}
	}
}