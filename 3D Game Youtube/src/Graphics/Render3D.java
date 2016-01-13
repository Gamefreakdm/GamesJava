package Graphics;

import Main.Main;

public class Render3D extends Render {
	public Render3D(int w, int h, Screen s) {
		super(w, h, s);
	}

	public void Floor() {
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = ((y - (getHeight() / 2.0)) / getHeight());
			double z = 20 / ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = ((x - (getWidth() / 2.0)) / getHeight());
				xdepth *= z;
				int xx = (int) xdepth;
				int yy = (int) (z + Main.GameTime + 30);
				screen.setPixelsfull(x + (y * getWidth()), ((xx & 15) << 4) | ((yy & 15) << 4) << 8);
			}
		}
	}
}