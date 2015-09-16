package base;

import Graphics.Sprite;

public class Screen {
	public static void Clear() {
		if (Main.Pixels[0] != 0)
			for (int i = 0; i < Main.Pixels.length; i++) {
				Main.Pixels[i] = 0;
			}
		;
	}

	public static void RenderBack() {
		Clear();
		for (int y = 0; y < Main.HEIGHT; y++) {
			if (y > Main.HEIGHT)
				continue;
			for (int x = 0; x < Main.WIDTH; x++) {
				if (x > Main.WIDTH)
					continue;
				Main.Pixels[x + y * Main.WIDTH] = 0x0;
			}
		}
	}

	public static void RenderBall(Sprite Ball) {
		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < 32; x++) {
				Main.Pixels[x + y * Main.WIDTH] = Ball.getPixels()[x + y * 32];
			}
		}
	}
}