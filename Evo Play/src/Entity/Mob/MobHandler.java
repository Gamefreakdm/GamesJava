package Entity.Mob;

import java.util.LinkedList;
import Graphics.Screen;

public class MobHandler {
	private LinkedList<Glob> Globlist = new LinkedList<Glob>();

	public void Update() {
		for (int i = 0; i < Globlist.size(); i++) {
			Glob temp = Globlist.get(i);
			temp.Update();
		}
	}

	public void Render(Screen screen) {
		for (int i = 0; i < Globlist.size(); i++) {
			Glob temp = Globlist.get(i);
			temp.Render(screen);
		}
	}

	public void addGlob(float x, float y) {
		Globlist.add(new Glob(x, y, 'y'));
	}
}