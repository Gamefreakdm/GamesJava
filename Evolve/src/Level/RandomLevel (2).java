package Level;

import java.util.Random;

public class RandomLevel extends Level {

	public RandomLevel(int ms) {
		super(ms);
		Tiles = new int[45 * 45];
		generateLevel();
	}

	protected void generateLevel() {
		Random random = new Random();
		for (int y = 0; y < mapSIZE; y++) {
			if (y < 0 || y >= mapSIZE)
				continue;
			for (int x = 0; x < mapSIZE; x++) {
				if (x < 0 || x >= mapSIZE)
					continue;
				Tiles[x + y * mapSIZE] = random.nextInt(40);
			}
		}
	}
}
