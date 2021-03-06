package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private int[] Pixels;
	private final int SIZE;
	public static SpriteSheet Player = new SpriteSheet("/Textures/Player.png", 64);
	public static SpriteSheet Tiles2 = new SpriteSheet("/Textures/Tiles2.png", 256);
	public static SpriteSheet Tiles1 = new SpriteSheet("/Textures/Tiles1.png", 1024);
	public static SpriteSheet Chars1 = new SpriteSheet("/Textures/Chars1.png", 1024);
	public static SpriteSheet InHandItems = new SpriteSheet("/Textures/InHandItems.png", 256);
	public static SpriteSheet InventoryItems1 = new SpriteSheet("/Textures/InventoryItems1.png", 1024);

	public SpriteSheet(String path, int Size) {
		Pixels = new int[Size * Size];
		Load(path, Size);
		SIZE = Size;
	}

	private void Load(String path, int s) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			img.getRGB(0, 0, s, s, Pixels, 0, s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getPixels() {
		return Pixels;
	}

	public int getSize() {
		return SIZE;
	}
}