package Graphics;

public class Sprite {
	private int size;
	public int[] Pixels;

	public Sprite(int s, int C) {
		size = s;
		Pixels = new int[s * s];
		for (int y = 0; y < s; y++) {
			for (int x = 0; x < s; x++) {
				Pixels[x + y * s] = C;
			}
		}
	}

	public int getSize() {
		return size;
	}
}