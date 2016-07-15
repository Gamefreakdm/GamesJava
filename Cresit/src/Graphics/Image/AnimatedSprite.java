package Graphics.Image;

import Graphics.Image.Sprite;
import Graphics.Image.SpriteSheet;

public class AnimatedSprite {
	private final Sprite sprites[];
	private final int WIDTH, HEIGHT;

	public static AnimatedSprite Player = new AnimatedSprite(SpriteSheet.Player, 64);

	public AnimatedSprite(SpriteSheet sheet, int w, int h) {
		sprites = new Sprite[8];
		WIDTH = w;
		HEIGHT = h;
		Load(w, h, sheet);
	}

	public AnimatedSprite(SpriteSheet sheet, int ss) {
		sprites = new Sprite[8];
		WIDTH = ss;
		HEIGHT = ss;
		Load(ss, sheet);
	}

	private void Load(int ss, SpriteSheet sheet) {
		int iter = 0;
		if (iter < sprites.length)
			for (int y = 0; y < 2; y++)
				for (int x = 0; x < 4; x++) {
					sprites[iter] = new Sprite(x, y, ss, sheet);
					iter++;
				}
	}

	private void Load(int w, int h, SpriteSheet sheet) {
		int iter = 0;
		if (iter < sprites.length)
			for (int y = 0; y < 2; y++)
				for (int x = 0; x < 4; x++) {
					sprites[iter] = new Sprite(x, y, w, h, sheet);
					iter++;
				}
	}

	public Sprite getSprite(int num) {
		return sprites[num];
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
}