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
	public final boolean[] Key = new boolean[68836];

	public void keyPressed(KeyEvent KP) {
		int keyCode = KP.getKeyCode();
		if (keyCode > 0 && keyCode < Key.length)
			Key[keyCode] = true;
	}

	public void keyReleased(KeyEvent KR) {
		for (int i = 0; i < Key.length; i++) {
			Key[i] = false;
		}
	}

	public void keyTyped(KeyEvent KT) {
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
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
		for (int i = 0; i < Key.length; i++) {
			Key[i] = false;
		}
	}
}