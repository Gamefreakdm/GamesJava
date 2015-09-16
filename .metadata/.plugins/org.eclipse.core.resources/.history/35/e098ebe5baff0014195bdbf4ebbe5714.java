package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public final boolean[] Keys = new boolean[5];
	private final boolean[] Codes = new boolean[129];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_ESCAPE];
		Keys[1] = Codes[KeyEvent.VK_LEFT];
		Keys[2] = Codes[KeyEvent.VK_RIGHT];
		Keys[3] = Codes[KeyEvent.VK_UP];
		Keys[4] = Codes[KeyEvent.VK_DOWN];
	}

	public void keyPressed(KeyEvent KP) {
		Codes[KP.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent KR) {
		Codes[KR.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent KT) {
	}
}