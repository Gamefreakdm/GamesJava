package Graphics;

import Main.Main;

public class Render3D extends Render {

	public Render3D(int w, int h) {
		super(w, h);
	}

	public void Floor() {
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = (y - getHeight() / 2.0) / getHeight();
			double z = 100.0 / ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = (x - getWidth() / 2.0) / getWidth();
				xdepth *= z;
				int xx = (int) xdepth & 15;
				int yy = (int) z & 5;
				Main.screen.setPixelsfull(x + (y * getWidth()), (xx & 4) + (yy & 4) + 64);
			}
		}
	}
}