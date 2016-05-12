package Graphics;

import Main.Game;

public class Render3D extends Render {
	private double xMove, zMove, rot;

	public Render3D(int w, int h, Game g) {
		super(w, h, g);
	}

	public void Floor(double time) {
		xMove = game.CO.x;
		zMove = game.CO.z;
		rot = game.CO.rot;
		double sine = Math.sin(rot);
		double cosine = Math.cos(rot);
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = ((y- (getHeight() / 2.0)) / getHeight());
			double z = 10 / ydepth;
			if (ydepth < 0)
				z = 10 / -ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = ((x - (getWidth() / 2.0)) / getHeight());
				xdepth *= z;
				int xx = (int) (xdepth * cosine + z * sine);
				int yy = (int) ((z * cosine - xdepth * sine));
				Pixels[x + (y * getWidth())] = ((xx & 15) << 4) | ((yy & 15) << 4) << 8;
			}
		}
	}
}