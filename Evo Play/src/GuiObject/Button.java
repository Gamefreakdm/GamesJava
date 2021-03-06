package GuiObject;

import Graphics.Screen;
import Main.Main;

public class Button {
	private final float X, Y;
	private final int slotnum;
	private final String Bname;
	private final int Width, Height;
	private boolean Clicked = false;
	private boolean Hovered = false;
	private boolean IsVisable = false;

	public Button(float x, float y, int w, int h, boolean iv, String bn) {
		X = x;
		Y = y;
		Width = w;
		Height = h;
		Bname = bn;
		IsVisable = iv;
		slotnum = -1;
	}

	public Button(float x, float y, int w, int h, boolean iv, int sn, String bn) {
		X = x;
		Y = y;
		Width = w;
		Height = h;
		Bname = bn;
		IsVisable = iv;
		slotnum = sn;
	}

	public void Update() {
		if (Clicked) {
			if (Bname == "char1" || Bname == "char2" || Bname == "char3" || Bname == "char4" || Bname == "char5")
				Main.setPlayer(Bname);
			switch (Bname) {
			case "sp":
				Main.setGS("Choose Character");
				break;
			case "Options":
				Main.setGS("Options");
				break;
			case "IB":
				Main.slotselected(slotnum);
				break;
			case "up0":
				System.out.println(Main.getPlayer().getSpeed());
				if (Main.getPlayer().getSpeed() == 1.0 || Main.getPlayer().getExp() >= (Main.getPlayer().getSpeed() * 10) * 2) {
					if (Main.getPlayer().getSpeed() == 1.0 && Main.getPlayer().getExp() >= 10) {
						Main.getPlayer().setSpeed(Main.getPlayer().getSpeed() + 0.2);
						Main.getPlayer().setExp(Main.getPlayer().getExp() + -10);
					} else if (Main.getPlayer().getExp() >= ((Main.getPlayer().getSpeed() * 10) * 2) && Main.getPlayer().getSpeed() < 3.0) {
						Main.getPlayer().setExp(Main.getPlayer().getExp() + -((Main.getPlayer().getSpeed() * 10) * 2));
						Main.getPlayer().setSpeed(Main.getPlayer().getSpeed() + 0.2);
					}
				}
				break;

			}
		}
		Clicked = false;
	}

	public void Render(Screen screen) {
		if (!IsVisable) {
			if (Hovered)
				screen.RenderSelect(X, Y, Width, Height, this);
		} else
			screen.RBC(X, Y, Width, Height, this);
	}

	public void CheckIsClicked(float x, float y) {
		if (x > X && x < X + Width && y > Y && y < Y + Height)
			Clicked = true;
		else
			Clicked = false;
	}

	public void CheckIsHovered(float x, float y) {
		if (x > X && x < X + Width && y > Y && y < Y + Height)
			Hovered = true;
		else
			Hovered = false;
	}

	public boolean Clicked() {
		return Clicked;
	}

	public boolean Hovered() {
		return Hovered;
	}
}