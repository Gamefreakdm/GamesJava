package Entity.Mob;

import java.util.LinkedList;
import Graphics.Screen;

public class MobHandler {
	private LinkedList<Mob> MobList = new LinkedList<Mob>();

	public void Update() {
		for (int i = 0; i < MobList.size(); i++) {
			Mob temp = MobList.get(i);
			temp.Update();
		}
	}

	public void Render(Screen screen) {
		for (int i = 0; i < MobList.size(); i++) {
			Mob temp = MobList.get(i);
			temp.Render(screen);
		}
	}

	public void addMob(float x, float y, char mob, int Level) {
		switch (mob) {
		case 'g':
			MobList.add(new Glob(x, y, mob, Level));
			break;
		case 'r':
			MobList.add(new Glob(x, y, mob, Level));
			break;
		case 'b':
			MobList.add(new Glob(x, y, mob, Level));
		case 'y':
			MobList.add(new Glob(x, y, mob, Level));
			break;
		case 'h':
			MobList.add(new Human(x, y, Level));
			break;
		}
	}
}