package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean[] Keys = new boolean[1];
	private final boolean[] Codes = new boolean[200];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_ESCAPE];
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