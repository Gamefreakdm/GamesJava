package GuiObject;

import Graphics.Screen;
import Graphics.Sprite;

public class Button {
	private final float X, Y;
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
	}

	public void Update() {
		if (Clicked) {
			if (Bname == "char1" || Bname == "char2" || Bname == "char3" || Bname == "char4" || Bname == "char5")
				Main.Main.setPlayer(Bname);
			switch (Bname) {
			case "singleplayer":
				Main.Main.setGS("Choose Character");
				break;
			case "Options":
				Main.Main.setGS("Options");
				break;
			case "IFS":
				Main.Main.setFS();
				break;
			case "Inventory":
				break;
			}
			Clicked = false;
		}
	}

	public void Render(Screen screen) {
		if (!IsVisable) {
			if (Hovered)
				screen.RenderEntity(X, Y, Sprite.Select);
		} else
			screen.RBC(X, Y, Width, Height, this);
	}

	public void CheckIsClicked(float x, float y) {
		if (x + (Main.Main.getScreenOffsetx()) > X && x < X + Width + Main.Main.getScreenOffsetx() && y > Y + Main.Main.getScreenOffsety() && y < Y + Height + Main.Main.getScreenOffsety())
			Clicked = true;
		else
			Clicked = false;
	}

	public void CheckIsHovered(float x, float y) {
		if (x > X + (Main.Main.getScreenOffsetx() / 2) && x < X + Width + (Main.Main.getScreenOffsetx() * 1.5) && y > Y + Main.Main.getScreenOffsety() && y < Y + Height + Main.Main.getScreenOffsety())
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