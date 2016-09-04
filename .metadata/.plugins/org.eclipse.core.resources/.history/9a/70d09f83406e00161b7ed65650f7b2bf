package Graphics.Render;

import Graphics.Image.Image;

public class Backround {
	private final Image Back;
	private final int Width, Height;

	public Backround(Image im) {
		Back = im;
		Width = im.getWidth();
		Height = im.getHeight();
	}

	public void Render(Screen screen) {
		screen.RenderImage(Back, 0, 0);
	}

	public Image getBack() {
		return Back;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}
}