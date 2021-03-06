package GuiObject.InventoryObject.Items;

import Graphics.Screen;
import Graphics.Sprite;

public class InventoryItem {
	private float X, Y;
	private Sprite sprite;
	private final String ID;
	private int SlotNum = 0;
	private Sprite minispriteR;
	private Sprite minispriteL;
	private boolean IsPicked = false;
	private boolean IsSelected = false;

	public InventoryItem(int sn, String id) {
		ID = id;
		SlotNum = sn;
		Init();
	}

	public void Init() {
		sprite = null;
		switch (ID) {
		case "stone sword":
			sprite = Sprite.Sword_II;
			setMinispriteR(Sprite.IHDSwordIIR);
			setMinispriteL(Sprite.IHDSwordIIL);
			break;
		case "0":
			sprite = Sprite.EmptySlot;
			break;
		}
		if (SlotNum < 8) {
			X = 80;
			X += SlotNum * 80;
			Y = 500;
		} else {
			X = 0;
			if (SlotNum < 13 && SlotNum >= 8) {
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
		screen.RenderPlayer(X, Y, getSprite());
	}

	public void IsPicked() {
		this.setIsPicked(true);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public String getID() {
		return ID;
	}

	public void setX(float x) {
		X = x;
	}

	public void setY(float y) {
		Y = y;
	}

	public boolean isIsSelected() {
		return IsSelected;
	}

	public void setIsSelected(boolean isSelected) {
		IsSelected = isSelected;
	}

	public boolean isIsPicked() {
		return IsPicked;
	}

	public void setIsPicked(boolean isPicked) {
		IsPicked = isPicked;
	}

	public void setSlot(int sn) {
		SlotNum = sn;
	}

	public int getSlotNum() {
		return SlotNum;
	}

	public float getY() {
		return Y;
	}

	public Sprite getMinispriteR() {
		return minispriteR;
	}

	public void setMinispriteR(Sprite minispriteR) {
		this.minispriteR = minispriteR;
	}

	public Sprite getMinispriteL() {
		return minispriteL;
	}

	public void setMinispriteL(Sprite minispriteL) {
		this.minispriteL = minispriteL;
	}
}