package Level;

import java.util.Random;

public class RandomLevel extends Level {

	public RandomLevel(int w, int h, int numt) {
		super(w, h);
		GenLevel(numt);
	}

	public RandomLevel(int s, int numt) {
		super(s);
		GenLevel(numt);
	}

	private void GenLevel(int numt) {
		Random random = new Random();
		for (int y = 0; y < getMapH(); y++) {
			for (int x = 0; x < getMapW(); x++) {
				getTiles()[x + (y * getMapW())] = random.nextInt(numt);
			}
		}
	}
}