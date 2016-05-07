package Graphics;

public class Render3D extends Render {

	public Render3D(int w, int h, Screen s) {
		super(w, h, s);
	}

	public void Floor(double time) {
		double rot = time / 110.0;
		double sine = Math.sin(rot);
		double cosine = Math.cos(rot);
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = ((y - (getHeight() / 2.0)) / getHeight());
			double z = 10 / ydepth;
			if (ydepth < 0)
				z = 8 / -ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = ((x - (getWidth() / 2.0)) / getHeight());
				xdepth *= z;
				int xx = (int) (xdepth * cosine + z * sine);
				int yy = (int) ((z * cosine - xdepth * sine));
				screen.setPixelsfull(x + (y * getWidth()), ((xx & 15) << 4) | ((yy & 15) << 4) << 8);
			}
		}
	}
}