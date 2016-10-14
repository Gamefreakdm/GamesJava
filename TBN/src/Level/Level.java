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
		for (int y = 0; y < 8; y++) {
			String temp = scanner.nextLine();
			System.out.println(temp.charAt(0));
			char[] ctemp = new char[temp.length()];
			for (int i = 0; i < temp.length(); i++) {
				ctemp[i] = temp.charAt(i);
			}
			for (int x = 0; x < 11; x++) {
				switch (ctemp[x + y]) {
				case 'a':
					System.out.println("sdfsf");
					Tiles[x + y] = Tile.grass;
					break;
				default:
					Tiles[x + y] = Tile.grass;
				}
			}
		}
	}

	public void RenderT(Screen screen) {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 11; x++) {
				screen.RenderTile(Tiles[x + y], x, y);
			}
		}
	}

	public void RenderAT(AnimatedTile tile, int xp, int yp) {
	}
}
