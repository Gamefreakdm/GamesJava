package Base;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean LEFT, RIGHT, ESC, SPACE, L, ENTER;
	private boolean[] Codes = new boolean[300];

	public void Update() {
		LEFT = Codes[KeyEvent.VK_LEFT];
		RIGHT = Codes[KeyEvent.VK_RIGHT];
		ESC = Codes[KeyEvent.VK_ESCAPE];
		SPACE = Codes[KeyEvent.VK_SPACE];
		L = Codes[KeyEvent.VK_L];
		ENTER = Codes[KeyEvent.VK_ENTER];
	}

	public void keyPressed(KeyEvent KP) {
		Codes[KP.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent KR) {
		Codes[KR.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}