package Graphics.Image;

public class AnimatedSprite {
	private final Sprite sprites[];
	public static AnimatedSprite Player = new AnimatedSprite(SpriteSheet.Player, 64);

	public AnimatedSprite(SpriteSheet sheet, int ss) {
		sprites = new Sprite[8];
		Load(ss, sheet);
	}

	private void Load(int ss, SpriteSheet sheet) {
		int iter = 0;
		if (iter < sprites.length)
			for (int y = 0; y < 2; y++) {
				for (int x = 0; x < 4; x++) {
					sprites[iter] = new Sprite(x, y, ss, sheet);
					iter++;
				}
			}
	}

	public Sprite getSprite(int num) {
		return sprites[num - 1];
	}
}