package Graphics;

import Main.Game;

public class Render3D extends Render {
	private final Game game;
	private final int MapSize;

	public Render3D(int w, int h, Game g) {
		super(w, h);
		game = g;
		MapSize = 16 << 4;
	}

	private double xMove, zMove, rot;

	public void Floor() {
		xMove = game().getCO().getX();
		zMove = game().getCO().getZ();
		rot = game().getCO().getRot();
		double sine = Math.sin(rot);
		double cosine = Math.cos(rot);
		for (int y = 0; y < getHeight(); y++) {
			double ydepth = ((y + (-getHeight() / 2.0)) / getHeight());
			double z = 8 / ydepth;
			if (ydepth < 0)
				z = 20 / -ydepth;
			for (int x = 0; x < getWidth(); x++) {
				double xdepth = ((x - (getWidth() / 2.0)) / getHeight());
				xdepth *= z;
				double xx = (((xdepth * cosine) + (z * sine)) + xMove);
				double yy = (((z * cosine) - (xdepth * sine)) + zMove);
				int xPix = (int) xx;
				int yPix = (int) yy;
				if (x < 0 || x > getWidth() || y < 0 || y > getHeight())
					continue;
				if (xx > MapSize || yy > MapSize || xx < -MapSize || yy < -MapSize)
					setPixels(x + (y * getWidth()), Texture.rock.getPixels()[(x & 15) + ((y & 15) << 4)]);
				else if (z > 300)
					continue;
				else {
					if (y > (getHeight() / 2))
						setPixels(x + (y * getWidth()), getRandTex(x, y).getPixels()[(xPix & getRandTex(x, y).getdeSize()) + (yPix & getRandTex(x, y).getdeSize()) * getRandTex(x, y).getSize()]);
					if (y < (getHeight() / 2))
						setPixels(x + (y * getWidth()), Texture.sky.getPixels()[(xPix & Texture.sky.getdeSize()) + (yPix & Texture.sky.getdeSize()) * Texture.sky.getSize()]);
				}
			}
		}
	}

	public Render getRandTex(int x, int y) {
		return Texture.floor;
	}

	public Game game() {
		return game;
	}
}