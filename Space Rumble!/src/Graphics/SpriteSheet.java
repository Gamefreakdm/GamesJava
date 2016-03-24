package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private final int SIZE;
	private final int[] Pixels;
	public static SpriteSheet Tiles = new SpriteSheet("/Textures/Tiles.png", 256);

	public SpriteSheet(String path, int s) {
		Pixels = new int[s * s];
		Load(path, s);
		SIZE = s;
	}

	private void Load(String path, int s) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			img.getRGB(0, 0, s, s, Pixels, 0, s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getSize() {
		return SIZE;
	}

	public int[] getPixels() {
		return Pixels;
	}
}