package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedList;
import Graphics.Screen;
import GuiObject.Button;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	private float mX, mY;
	private LinkedList<Button> Buttons = new LinkedList<Button>();

	public void UpdateButtons(String gs) {
		this.ClearButtons();
		switch (gs) {
		case "Home":
			Buttons.add(new Button(193, 166, 383, 73, true, "sp"));
			break;
		case "Choose Character":
			Buttons.add(new Button(40 + (160 * 0), 0, 64, 64, false, "char1"));
			break;
		}
	}

	public void CreateUpgradeButtons(int yp) {
		Buttons.add(new Button(736, (68 * yp), 64, 64, false, "up" + yp));
	}

	public void CreateInventoryButton(int xp, int yp, int slot, boolean ish) {
		if (!ish) {
			int offx = 64 * xp;
			int offy = 64 * yp;
			Buttons.add(new Button(offx, offy, 64, 64, false, slot, "IB"));
		} else {
			int offx = (80 * xp) - 32;
			Buttons.add(new Button(offx - 48, 500, 64, 64, false, slot, "IB"));
		}
	}

	public void DestoryInventoryButtons() {
		Buttons.clear();
	}

	public void RenderButtons(Screen screen) {
		for (int i = 0; i < Buttons.size(); i++) {
			Button temp = Buttons.get(i);
			temp.Render(screen);
		}
	}

	public void CheckIsClicked() {
		for (int i = 0; i < Buttons.size(); i++) {
			Buttons.get(i).CheckIsClicked(this.getMouseX(), this.getMouseY());
		}
	}

	public void CheckIsHovered() {
		for (int i = 0; i < Buttons.size(); i++) {
			Buttons.get(i).CheckIsHovered(this.getMouseX(), this.getMouseY());
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
		CheckIsClicked();
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

	public void mouseWheelMoved(MouseWheelEvent mwe) {
		Main.Main.getScrollamount((int) mwe.getPreciseWheelRotation());
	}

	public float getMouseX() {
		return mX;
	}

	public float getMouseY() {
		return mY;
	}
}