package Graphics;

import Base.Main;
import Level.Wall;
import Objects.Object;

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
		for (int y = 0; y < Main.Height; y++) {
			if (y > Main.Height)
				continue;
			for (int x = 0; x < Main.Width; x++) {
				if (x > Main.Width)
					continue;
				Main.Pixels[x + y * Main.Width] = 0xFFFFFF;
			}
		}
	}

	public static void RenderP(float xp, float yp, Sprite sp) {
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + yp);
			if (ya >= Main.Height)
				break;
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + xp);
				if (xa >= Main.Width)
					continue;
				int col = sp.Pixels[x + y * 32];
				if (col != 0xFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = sp.Pixels[x + y * 32];
			}
		}
	}

	public static void RenderWall(Wall w) {
		for (int y = 0; y < w.getHeight(); y++) {
			int ya = (int) (y + w.getY());
			for (int x = 0; x < w.getWidth(); x++) {
				int xa = (int) (x + w.getX());
				Main.Pixels[xa + ya * Main.Width] = 0x0;
			}
		}
	}

	public static void RenderObjects(Object ob) {
		for (int y = 0; y < 32; y++) {
			int ya = (int) (y + ob.getY());
			if (ya >= Main.Height)
				break;
			for (int x = 0; x < 32; x++) {
				int xa = (int) (x + ob.getX());
				if (xa >= Main.Width)
					continue;
				int col = ob.getSprite().Pixels[x + y * 32];
				if (col != 0xFFFF00FF)
					Main.Pixels[xa + ya * Main.Width] = ob.getSprite().Pixels[x + y * 32];
			}
		}
	}
}