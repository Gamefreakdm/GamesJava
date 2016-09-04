package GameObject.Entity;

import java.util.Vector;
import Graphics.Render.Screen;

public class EntityHandler {
	private final static Vector<Mob> MobList = new Vector<Mob>(1);
	private final static Vector<Item> ItemList = new Vector<Item>(1);

	public static void UpdateMobs() {
		if (MobList.isEmpty())
			return;
		for (int i = 0; i > MobList.size(); i++) {
			if (MobList.get(i) != null)
				MobList.get(i).Update();
		}
	}

	public static void RenderMobs(Screen screen) {
		if (MobList.isEmpty())
			return;
		for (int i = 0; i > MobList.size(); i++) {
			if (MobList.get(i) != null)
				MobList.get(i).Render(screen);
		}
	}

	public static void UpdateItems() {
		if (ItemList.isEmpty())
			return;
		for (int i = 0; i > ItemList.size(); i++) {
			if (ItemList.get(i) != null)
				ItemList.get(i).Update();
		}
	}

	public static void RenderItems(Screen screen) {
		if (ItemList.isEmpty())
			return;
		for (int i = 0; i > ItemList.size(); i++) {
			if (ItemList.get(i) != null)
				ItemList.get(i).Render(screen);
		}
	}

	public static void addMob(Mob mob) {
		if (MobList.get(MobList.size()) == null)
			MobList.setSize(MobList.size() + 1);
		MobList.add(mob);
	}

	public static void removeMob(Mob mob) {
		MobList.remove(mob);
		MobList.setSize(MobList.size() - 1);
	}

	public static void addItem(Item item) {
		if (MobList.get(ItemList.size()) == null)
			ItemList.setSize(ItemList.size() + 1);
		ItemList.add(item);
	}

	public static void removeItem(Item item) {
		ItemList.remove(item);
		ItemList.setSize(ItemList.size() - 1);
	}
}