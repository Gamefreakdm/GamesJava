package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean[] Keys = new boolean[6];
	private boolean[] Codes = new boolean[120];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_ESCAPE];
		Keys[1] = Codes[KeyEvent.VK_RIGHT];
		Keys[2] = Codes[KeyEvent.VK_LEFT];
		Keys[3] = Codes[KeyEvent.VK_UP];
		Keys[4] = Codes[KeyEvent.VK_DOWN];
	}

	public void keyPressed(KeyEvent KP) {
		Codes[KP.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent KR) {
		Codes[KR.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent KT) {
	}
}