package Graphics;

import Main.Main;

public class Render3D extends Render {

	public Render3D(int w, int h) {
		super(w, h);
	}

	double Timer = 0;

	public void Floor() {
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = (y - getHeight() / 2.0) / getHeight();
			double z = 8 / ydepth;
			for (int x = 0; x < getWidth(); x++) {
				Timer += 0.0000005;
				double xdepth = (x - getWidth() / 2.0) / getHeight();
				xdepth *= z;
				int xx = (int) (xdepth) & 15;
				int yy = (int) (z + Timer) & 15;
				Main.screen.setPixelsfull(x + (y * getWidth()), (xx << 4) | (yy << 4) << 8);
			}
		}
	}
}