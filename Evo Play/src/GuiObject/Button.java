package GuiObject;

import Graphics.Screen;
import Graphics.Sprite;
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
			}
			Clicked = false;
		}
	}

	public void Render(Screen screen) {
		if (!IsVisable) {
			if (Hovered)
				screen.RenderInventoryButton(X, Y, Sprite.Select);
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