package base;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean ESC;
	private boolean[] Codes = new boolean[120];

	public void Update() {
		ESC = Codes[KeyEvent.VK_ESCAPE];
	}

	public void keyPressed(KeyEvent kp) {
		Codes[kp.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent kr) {
		Codes[kr.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent kt) {
	}
}