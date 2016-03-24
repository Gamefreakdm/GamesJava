package Items;

import Graphics.Screen;
import Graphics.Sprite;

public class InventoryItem {
	private String ID = "";
	private int SlotNum = 0;
	private Sprite sprite;
	private int Health = 0;
	private float X, Y;
	private boolean IsPicked = false;
	private boolean IsSelected = false;

	public InventoryItem(int sn, String id) {
		ID = id;
		SlotNum = sn;
		Init();
	}

	private void Init() {
		sprite = null;
		switch (ID) {
		case "stone sword":
			Health = 20;
			sprite = Sprite.Sword_II;
			break;
		case "0":
			Health = -1;
			sprite = Sprite.EmptySlot;
			break;
		}
		if (SlotNum < 8) {
			X = 80;
			X += SlotNum * 80;
			Y = 500;
		} else {
			X = 0;
			if (SlotNum < 13 && SlotNum > 7) {
				Y = 0;
				X += (SlotNum - 9) * 64;
			} else if (SlotNum < 17 && SlotNum >= 13) {
				Y = 64;
				X += (SlotNum - 13) * 64;
			} else if (SlotNum < 21 && SlotNum >= 17) {
				Y = 128;
				X += (SlotNum - 17) * 64;
			} else if (SlotNum < 25 && SlotNum >= 21) {
				Y = 192;
				X += (SlotNum - 21) * 64;
			}
		}
	}

	public void Render(Screen screen) {
		screen.RenderEntity(X, Y, getSprite());
	}

	public void IsPicked(float x, float y) {
	}

	public Sprite getSprite() {
		return sprite;
	}

	public String getID() {
		return ID;
	}

	public boolean isIsSelected() {
		return IsSelected;
	}

	public void setIsSelected(boolean isSelected) {
		IsSelected = isSelected;
	}
}