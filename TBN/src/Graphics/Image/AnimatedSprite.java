package Graphics.Image;

import Graphics.Image.Sprite;
import Graphics.Image.SpriteSheet;

public class AnimatedSprite {
	private final Sprite sprites[];
	private final int WIDTH, HEIGHT;
	public static AnimatedSprite Player = new AnimatedSprite(SpriteSheet.Player, 64, 2, 6);

	public AnimatedSprite(SpriteSheet sheet, int w, int h, int maxy, int maxx) {
		sprites = new Sprite[maxy * maxx];
		WIDTH = w;
		HEIGHT = h;
		Load(maxy, maxx, w, h, sheet);
	}

	public AnimatedSprite(SpriteSheet sheet, int ss, int maxy, int maxx) {
		sprites = new Sprite[maxy * maxx];
		WIDTH = ss;
		HEIGHT = ss;
		Load(maxy, maxx, ss, sheet);
	}

	private void Load(int maxy, int maxx, int ss, SpriteSheet sheet) {
		int iter = 0;
		if (iter < sprites.length)
			for (int y = 0; y < maxy; y++)
				for (int x = 0; x < maxx; x++) {
					sprites[iter] = new Sprite(x, y, ss, sheet);
					iter++;
				}
	}

	private void Load(int maxy, int maxx, int w, int h, SpriteSheet sheet) {
		int iter = 0;
		if (iter < sprites.length)
			for (int y = 0; y < maxy; y++)
				for (int x = 0; x < maxx; x++) {
					sprites[iter] = new Sprite(x, y, w, h, sheet);
					iter++;
				}
	}

	public Sprite getSprite(int num) {
		return sprites[num];
	}

	public int getSize() {
		return sprites.length;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
}