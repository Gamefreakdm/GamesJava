package Entity.Mob;

import java.util.LinkedList;
import java.util.Random;

public class MobHandler {
	private LinkedList<HappyPerson> hplist = new LinkedList<HappyPerson>();
	private LinkedList<SadPerson> splist = new LinkedList<SadPerson>();

	public void addHappyPerson() {
		Random random = new Random();
		float x = random.nextInt(1379);
		float y = random.nextInt(1377);
		int sp = random.nextInt(3);
		String Char = "";
		if (sp == 0)
			Char = "Farm";
		if (sp == 1)
			Char = "Gen";
		if (sp == 2)
			Char = "Sol";
		if (x < 26.0)
			x = (float) 26.0;
		if (y < 32.0)
			y = (float) 32.0;
		hplist.add(new HappyPerson(x, y, Char));
	}

	public void addSadPerson() {
		Random random = new Random();
		float x = random.nextInt(1379);
		float y = random.nextInt(1377);
		int sp = random.nextInt(3);
		String Char = "";
		if (sp == 0)
			Char = "Farm";
		if (sp == 1)
			Char = "Gen";
		if (sp == 2)
			Char = "Sol";
		if (x < 26.0)
			x = (float) 26.0;
		if (y < 32.0)
			y = (float) 32.0;
		splist.add(new SadPerson(x, y, Char));
	}

	public void Update() {
		for (int i = 0; i < hplist.size(); i++) {
			HappyPerson temp = hplist.get(i);
			temp.Update();
		}
		for (int i = 0; i < splist.size(); i++) {
			SadPerson temp = splist.get(i);
			temp.Update();
		}
	}

	public void Render() {
		for (int i = 0; i < hplist.size(); i++) {
			HappyPerson temp = hplist.get(i);
			temp.Render();
		}
		for (int i = 0; i < splist.size(); i++) {
			SadPerson temp = splist.get(i);
			temp.Render();
		}
	}
}