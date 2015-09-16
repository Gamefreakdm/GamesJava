package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private int[] Pixels;
	public static SpriteSheet Sp1 = new SpriteSheet("/Textures/Sp1.png");

	public SpriteSheet(String Path) {
		Pixels = new int[65536];
		Load(Path);
	}

	private void Load(String path) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			img.getRGB(0, 0, 256, 256, Pixels, 0, 256);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getPixels() {
		return Pixels;
	}
}