package Graphics;

import Main.Game;

public class Screen {
	private int[] Pixels;
	private final Render3D R3D;
	private final int Width, Height;

	public Screen(int w, int h, Game g) {
		this.Height = h;
		this.Width = w;
		R3D = new Render3D(getWidth(), getHeight(), g);
	}

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
	}

	public void Render(double time) {
		R3D.Floor(time);
		Pixels = R3D.getPixels();
	}

	private int getWidth() {
		return Width;
	}

	public int[] getPixels() {
		return Pixels;
	}

	public void setPixels(int[] l) {
		Pixels = l;
	}

	private int getHeight() {
		return Height;
	}
}