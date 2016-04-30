package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean[] Keys = new boolean[3];
	private final boolean[] Codes = new boolean[200];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_ESCAPE];
		Keys[1] = Codes[KeyEvent.VK_UP];
		Keys[2] = Codes[KeyEvent.VK_DOWN];
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