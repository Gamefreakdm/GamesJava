package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private int[] Pixels;
	public static SpriteSheet Tiles = new SpriteSheet("/Textures/Tiles1.png");
	public static SpriteSheet Chars1 = new SpriteSheet("/Textures/Chars1.png");

	public SpriteSheet(String path) {
		Pixels = new int[1024 * 1024];
		Load(path);
	}

	private void Load(String path) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			img.getRGB(0, 0, 1024, 1024, Pixels, 0, 1024);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getPixels() {
		return Pixels;
	}
}