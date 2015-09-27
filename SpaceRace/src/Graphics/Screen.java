package Graphics;

import Main.Main;

public class Screen {
	private static void clearPixels(int[] p) {
		for (int i = 0; i < p.length; i++)
			p[i] = 0;
	}

	public static void Render(int[] p) {
		clearPixels(p);
		for (int y = 0; y < Main.HEIGHT; y++) {
			if (y < 0 || y >= Main.WIDTH)
				break;
			for (int x = 0; x < Main.WIDTH; x++) {
				if (x < 0 || x >= Main.WIDTH)
					break;
				p[x + y * Main.WIDTH] = 0x0ff00ff31;
			}
		}
	}
}