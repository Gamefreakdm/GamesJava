package Graphics;

public class AnimatedSprite {
	private int frame = 0;
	private Sprite sprite;
	private int rate = 5;
	private int length = -1;
	private Sprite[] sprites;

	public static AnimatedSprite test = new AnimatedSprite(SpriteSheet.Player, 64, 8);

	public AnimatedSprite(SpriteSheet sheet, int ss, int length) {
		this.length = length;
		sprites = new Sprite[length];
		this.load(length, sheet, ss);
		sprite = sprites[15];
	}

	private void load(int length, SpriteSheet sheet, int s) {
		int iter = 0;
		for (int y = 0; y < (length / 4); y++)
			for (int x = 0; x < (length / 4); x++) {
				sprites[iter] = new Sprite(x, y, sheet, s, false, false);
				iter++;
			}
	}

	public void Update() {
		if (frame > length)
			frame = 0;
		else
			frame++;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setFrameRate(int frames) {
		this.rate = frames;
	}
}