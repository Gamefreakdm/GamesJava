package Level;

import java.util.Random;
import Graphics.Render.Screen;

public class Level {
	private final int SIZE;
	private final int[] Tiles;

	public Level(int s, char type) {
		SIZE = s;
		Tiles = new int[s * s];
		if (type == 'r')
			GenerateLevel();
		else if (type == 'a')
			LoadLevel(type);

	}

	public void Render(Screen screen) {
	}

	public void Update() {
	}

	public void LoadLevel(char t) {
	}

	public void GenerateLevel() {
		Random random = new Random();
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				Tiles[x + (y * SIZE)] = random.nextInt(3);
	}

	public int getSIZE() {
		return SIZE;
	}
}