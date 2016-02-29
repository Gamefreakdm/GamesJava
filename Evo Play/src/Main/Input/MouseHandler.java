package Main.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import Graphics.Screen;
import GuiObject.Button;

public class MouseHandler implements MouseListener, MouseMotionListener {
	private float mX, mY;
	private LinkedList<Button> Buttons = new LinkedList<Button>();

	public void UpdateButtons(String gs) {
		this.ClearButtons();
		switch (gs) {
		case "Home":
			Buttons.add(new Button(193, 166, 383, 73, true, "singleplayer"));
			Buttons.add(new Button(193, 266, 383, 73, true, "Options"));
			break;
		case "Options":
			Buttons.add(new Button(193, 166, 395, 73, true, "IFS"));
			break;
		case "Choose Character":
			Buttons.add(new Button(40 + (160 * 0), 0, 64, 64, false, "char1"));
			Buttons.add(new Button(40 + (160 * 1), 0, 64, 64, false, "char2"));
			Buttons.add(new Button(40 + (160 * 2), 0, 64, 64, false, "char3"));
			Buttons.add(new Button(40 + (160 * 3), 0, 64, 64, false, "char4"));
			Buttons.add(new Button(40 + (160 * 4), 0, 64, 64, false, "char5"));
			break;
		}
	}

	public void RenderButtons(Screen screen) {
		for (int i = 0; i < Buttons.size(); i++) {
			Button temp = Buttons.get(i);
			temp.Render(screen);
		}
	}

	public void CheckIsClicked(float x, float y) {
		for (int i = 0; i < Buttons.size(); i++) {
			Button temp = Buttons.get(i);
			temp.CheckIsClicked(x, y);
		}
	}

	public void CheckIsHovered(float x, float y) {
		for (int i = 0; i < Buttons.size(); i++) {
			Button temp = Buttons.get(i);
			temp.CheckIsHovered(x, y);
		}
	}

	public void UpdateButtons() {
		for (int i = 0; i < Buttons.size(); i++) {
			Button temp = Buttons.get(i);
			temp.Update();
		}
	}

	public void ClearButtons() {
		Buttons.clear();
	}

	public void mouseEntered(MouseEvent men) {
	}

	public void mouseExited(MouseEvent mex) {
	}

	public void mousePressed(MouseEvent mp) {
		CheckIsClicked(mX, mY);
	}

	public void mouseReleased(MouseEvent mr) {
	}

	public void mouseClicked(MouseEvent mc) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent ME) {
		mX = ME.getX();
		mY = ME.getY();
	}

	public float getX() {
		return mX;
	}

	public float getY() {
		return mY;
	}
}