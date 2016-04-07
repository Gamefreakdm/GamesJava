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
		if (this.getDir() > 0)
			IsMoving = true;
		else
			IsMoving = false;
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
	}

	public void Render(Screen screen, boolean ini) {
		Anim();
		screen.RenderPlayer(getX(), getY(), getSprite());
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
				this.animTimer++;
				if (animTimer <= 8)
					this.setSprite(Sprite.Human_B);
				else
					this.setSprite(Sprite.Human_BF);
				if (animTimer >= 13)
					animTimer = 0;
				break;
			case 1:
				this.animTimer++;
				if (animTimer <= 8)
					this.setSprite(Sprite.Human_F);
				else
					this.setSprite(Sprite.Human_FF);
				if (animTimer >= 13)
					animTimer = 0;
				break;
			case 2:
				this.animTimer++;
				if (animTimer <= 3)
					this.setSprite(Sprite.Human_LS);
				if (animTimer <= 6 && animTimer > 3)
					this.setSprite(Sprite.Human_LK);
				if (animTimer <= 9 && animTimer > 6)
					this.setSprite(Sprite.Human_L);
				if (animTimer <= 12 && animTimer > 9)
					this.setSprite(Sprite.Human_L);
				if (animTimer <= 15 && animTimer > 12)
					this.setSprite(Sprite.Human_LK);
				if (animTimer <= 18 && animTimer > 15)
					this.setSprite(Sprite.Human_LS);
				if (animTimer > 21)
					animTimer = 0;
				break;
			case 3:
				this.animTimer++;
				if (animTimer <= 3)
					this.setSprite(Sprite.Human_RS);
				if (animTimer <= 6 && animTimer > 3)
					this.setSprite(Sprite.Human_RK);
				if (animTimer <= 9 && animTimer > 6)
					this.setSprite(Sprite.Human_R);
				if (animTimer <= 12 && animTimer > 9)
					this.setSprite(Sprite.Human_R);
				if (animTimer <= 15 && animTimer > 12)
					this.setSprite(Sprite.Human_RK);
				if (animTimer <= 18 && animTimer > 15)
					this.setSprite(Sprite.Human_RS);
				if (animTimer > 21)
					animTimer = 0;
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