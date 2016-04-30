package Graphics.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
	private int[] Pixels;
	private int WIDTH, HEIGHT;
	private int SIZE;
	public static Image SpaceBack = new Image("/Backrounds/SpaceBack.png");

	public Image(String p) {
		Load(p);
	}

	private void Load(String path) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			WIDTH = img.getWidth();
			HEIGHT = img.getHeight();
			Pixels = new int[WIDTH * HEIGHT];
			SIZE = WIDTH * HEIGHT;
			img.getRGB(0, 0, img.getWidth(), img.getHeight(), Pixels, 0, img.getWidth());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getPixels() {
		return Pixels;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getSIZE() {
		return SIZE;
	}
}