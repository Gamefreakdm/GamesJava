package Graphics;

import Main.Game;

public class Screen {
	private final Render3D R3D;
	@SuppressWarnings("unused")
	private final int Width, Height;

	public Screen(int w, int h, Game g) {
		this.Height = h;
		this.Width = w;
		R3D = new Render3D(w, h, g);
	}

	private int[] Pixels;

	public void clearPixels() {
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
	}

	public void Render() {
		R3D.Floor();
		Pixels = R3D.getPixels();
	}

	public int[] getPixels() {
		return Pixels;
	}
}