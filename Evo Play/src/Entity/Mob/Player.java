package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;
import GuiObject.InventoryObject.Items.InventoryItem;

public class Player extends Mob {
	private int handnum = 0;
	private final InventoryItem[] IL = new InventoryItem[25];

	public Player(Sprite sprite, char c) {
		this.setSprite(sprite);
		this.setCar(c);
		Init();
	}

	public void Update() {
		if (getSpeed() > 3.0)
			setSpeed(3.0);
	}

	public void UpdateInventory(boolean ini) {
		for (int i = 0; i < IL.length; i++) {
			if (!ini) {
				IL[i].setIsPicked(false);
				IL[i].Init();
			}
			if (IL[i].getID() != "0" && IL[i].isIsPicked()) {
				IL[i].setX(Main.Main.getMouseHandler().getMouseX() - 32);
				IL[i].setY(Main.Main.getMouseHandler().getMouseY() - 32);
			}
		}
	}

	private void Init() {
		this.setX((800 / 2) - 30);
		this.setY((600 / 2) - 30);
		for (int i = 0; i < 25; i++)
			IL[i] = new InventoryItem(i, "0");
		IL[0] = new InventoryItem(0, "stone sword");
		IL[0].setIsSelected(true);
		Anim();
	}

	public void Render(Screen screen, boolean ini) {
		if (isIsMoving())
			Anim();
		switch (this.getDir()) {
		case 0:
			for (int i = 0; i < IL.length; i++) {
				if (IL[i].getID() != "0" && IL[i].isIsSelected())
					screen.RenderImage(this.getIHX(), this.getIHY(), 32, 32, IL[i].getMinispriteR());
			}
			screen.RenderPlayer(getX(), getY(), getSprite());
			break;
		case 1:
			screen.RenderPlayer(getX(), getY(), getSprite());
			for (int i = 0; i < IL.length; i++) {
				if (IL[i].getID() != "0" && IL[i].isIsSelected())
					screen.RenderImage(this.getIHX(), this.getIHY(), 32, 32, IL[i].getMinispriteR());
			}
			break;
		case 2:
			screen.RenderPlayer(getX(), getY(), getSprite());
			for (int i = 0; i < IL.length; i++) {
				if (IL[i].getID() != "0" && IL[i].isIsSelected())
					screen.RenderImage(this.getIHX(), this.getIHY(), 32, 32, IL[i].getMinispriteL());
			}
			break;
		default:
			screen.RenderPlayer(getX(), getY(), getSprite());
			for (int i = 0; i < IL.length; i++) {
				if (IL[i].getID() != "0" && IL[i].isIsSelected())
					screen.RenderImage(this.getIHX(), this.getIHY(), 32, 32, IL[i].getMinispriteR());
			}
			break;
		}
		for (int i = 0; i < 25; i++)
			if (IL[i].getID() != "0") {
				if (i <= 7)
					IL[i].Render(screen);
				if (i >= 8 && ini)
					IL[i].Render(screen);
			}
	}

	public void Anim() {
		switch (this.getCar()) {
		case '4':
			switch (this.getDir()) {
			case 0:
				this.setIHX(this.getX() + 13);
				this.setIHY(this.getY() + 20);
				this.setAnimTimer(this.getAnimTimer() + 1);
				if (getAnimTimer() <= 8)
					this.setSprite(Sprite.Human_B);
				else
					this.setSprite(Sprite.Human_BF);
				if (getAnimTimer() >= 13)
					setAnimTimer(0);
				break;
			case 1:
				this.setIHX(this.getX() + 16);
				this.setIHY(this.getY() + 22);
				this.setAnimTimer(this.getAnimTimer() + 1);
				if (getAnimTimer() <= 8)
					this.setSprite(Sprite.Human_F);
				else
					this.setSprite(Sprite.Human_FF);
				if (getAnimTimer() >= 13)
					setAnimTimer(0);
				break;
			case 2:
				this.setAnimTimer(this.getAnimTimer() + 1);
				if (getAnimTimer() <= 3 || getAnimTimer() <= 18 && getAnimTimer() > 15) {
					this.setIHX(this.getX() + 2);
					this.setIHY(this.getY() + 22);
					this.setSprite(Sprite.Human_LS);
				}
				if (getAnimTimer() <= 6 && getAnimTimer() > 3 || getAnimTimer() <= 15 && getAnimTimer() > 12) {
					this.setSprite(Sprite.Human_LK);
				}
				if (getAnimTimer() <= 9 && getAnimTimer() > 6 && getAnimTimer() <= 12 && getAnimTimer() > 9) {
					this.setSprite(Sprite.Human_L);
				}
				if (getAnimTimer() > 21)
					setAnimTimer(0);
				break;
			case 3:
				this.setAnimTimer(this.getAnimTimer() + 1);
				if (getAnimTimer() <= 3 || getAnimTimer() <= 18 && getAnimTimer() > 15) {
					this.setIHX(this.getX() + 32);
					this.setIHY(this.getY() + 22);
					this.setSprite(Sprite.Human_RS);
				}
				if (getAnimTimer() <= 6 && getAnimTimer() > 3 || getAnimTimer() <= 15 && getAnimTimer() > 12) {
					this.setSprite(Sprite.Human_RK);
				}
				if (getAnimTimer() <= 9 && getAnimTimer() > 6 && getAnimTimer() <= 12 && getAnimTimer() > 9) {
					this.setSprite(Sprite.Human_R);
				}
				if (getAnimTimer() > 21)
					setAnimTimer(0);
				break;
			}
			break;
		}
	}

	public InventoryItem[] getInventory() {
		return this.IL;
	}

	public void setNextF(int f) {
		IL[handnum].setIsSelected(false);
		if (handnum + f > 8) {
			IL[0].setIsSelected(true);
			handnum = 0;
		} else if (handnum + f < 0) {
			IL[8].setIsSelected(true);
			handnum = 8;
		} else {
			IL[handnum + f].setIsSelected(true);
			handnum += f;
		}
	}
}