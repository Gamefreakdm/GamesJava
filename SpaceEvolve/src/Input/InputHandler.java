package Input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class InputHandler implements FocusListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	private final boolean[] Key = new boolean[68836];

	public void keyPressed(KeyEvent KP) {
		int keyCode = KP.getKeyCode();
		if (keyCode > 0 && keyCode < Key.length)
			Key[keyCode] = true;
	}

	public void keyReleased(KeyEvent KR) {
		int keyCode = KR.getKeyCode();
		if (keyCode > 0 && keyCode < Key.length)
			Key[keyCode] = false;
	}

	public void keyTyped(KeyEvent KT) {
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	private double pastmx = 0;
	private double mousex, mousey, mxc;

	public void mouseMoved(MouseEvent mm) {
		mxc = (mm.getX() - pastmx);
		pastmx = mm.getX();
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
		mousex = arg0.getX();
		mousey = arg0.getY();
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void focusGained(FocusEvent arg0) {
	}

	public void focusLost(FocusEvent arg0) {
	}

	public double getMousex() {
		return mousex;
	}

	public double getMousey() {
		return mousey;
	}

	public double getMxc() {
		return mxc;
	}

	public boolean getKey(int code) {
		return Key[code];
	}
}