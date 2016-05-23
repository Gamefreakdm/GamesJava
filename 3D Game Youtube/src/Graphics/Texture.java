package Graphics;

public class Texture {
	public static Render floor = LoadBitmap(Sprite.Plain);
	public static Render sky = LoadBitmap(Sprite.Sky);
	public static Render rock = LoadBitmap(Sprite.Rock);

	public static Render LoadBitmap(Sprite sprite) {
		Render result = new Render(sprite.getSize());
		for (int i = 0; i < sprite.getPixels().length; i++)
			result.setPixels(i, sprite.getPixels()[i]);
		return result;
	}
}