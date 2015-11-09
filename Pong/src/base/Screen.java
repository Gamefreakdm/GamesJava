package base;

import Graphics.Sprite;

public class Screen {
	public static void Clear() {
		if (Main.Pixels[0] != 0)
			for (int i = 0; i < Main.Pixels.length; i++) {
				Main.Pixels[i] = 0;
			}
	}

	public static void RenderBack() {
		Clear();
		for (int y = 0; y < Main.Height; y++) {
			if (y > Main.Height)
				continue;
			for (int x = 0; x < Main.Width; x++) {
				if (x > Main.Width)
					continue;
				Main.Pixels[x + y * Main.Width] = 0x0;
			}
		}
	}

	public static void RenderBall(Sprite Ball) {
		for (int y = 0; y < 32; y++) {
			for (int x = 0; x < 32; x++) {
				Main.Pixels[x + y * Main.Width] = Ball.getPixels()[x + y * 32];
			}
		}
	}

	public static void RenderPaddle(Sprite Paddle) {
		for (int y = 0; y < 110; y++) {
			for (int x = 0; x < 32; x++) {
				Main.Pixels[x + y * Main.Width] = Paddle.getPixels()[x + y * 32];
			}
		}
	}
}