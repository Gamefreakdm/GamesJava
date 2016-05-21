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
			double ydepth = ((y + -getHeight() / 2.0) / getHeight());
			double z = 8 / ydepth;
			if (ydepth < 0)
				z = 8 / -ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = ((x - (getWidth() / 2.0)) / getHeight());
				xdepth *= z;
				double xx = (xdepth * cosine + z * sine) + xMove;
				double yy = (z * cosine - xdepth * sine) + zMove;
				int xPix = (int) xx;
				int yPix = (int) yy;
				Pixels[x + (y * getWidth())] = (((xPix & 15) << 4) | ((yPix & 15) << 4)) << 8;
			}
		}
	}
}