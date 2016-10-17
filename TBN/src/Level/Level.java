package Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Graphics.Render.Screen;
import Level.Tile.AnimatedTile;
import Level.Tile.Tile;

public class Level {
	private Scanner scanner = null;
	private Tile[] Tiles = new Tile[109];

	public Level(File file) {
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CreateLevel();
	}

	private void CreateLevel() {
		for (int y = 0; y < 9; y++) {
			String temp = scanner.nextLine();
			char[] ctemp = new char[temp.length()];
			for (int i = 0; i < temp.length(); i++) {
				ctemp[i] = temp.charAt(i);
			}
			for (int x = 0; x < 12; x++) {
				switch (ctemp[x]) {
				case 'a':
					Tiles[x + y] = Tile.grass;
					break;
				default:
					System.out.println("Defult");
					Tiles[x + y] = Tile.grass;
				}
			}
		}
	}

	public void RenderT(Screen screen) {
		for (int y = 0; y < 9; y++) {
			int ya = y * 64;
			for (int x = 0; x < 12; x++) {
				int xa = x * 64;
				screen.RenderTile(Tiles[x + y], xa, ya);
			}
		}
	}

	public void RenderAT(AnimatedTile tile, int xp, int yp) {
	}
}
