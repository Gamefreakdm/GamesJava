package Graphics.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private int Width, Height;
	private int[] Pixels;
	public static SpriteSheet Chars = new SpriteSheet("/Textures/Chars.png");
	public static SpriteSheet Tiles = new SpriteSheet("/Textures/Tiles.png");
	public static SpriteSheet Player = new SpriteSheet("/Textures/Player.png");

	public SpriteSheet(String path) {
		Load(path);
	}

	private void Load(String path) {
		try {
			BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(path));
			Width = img.getWidth();
			Height = img.getHeight();
			Pixels = new int[Width * Height];
			img.getRGB(0, 0, img.getWidth(), img.getHeight(), Pixels, 0, img.getWidth());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}

	public int[] getPixels() {
		return Pixels;
	}
}