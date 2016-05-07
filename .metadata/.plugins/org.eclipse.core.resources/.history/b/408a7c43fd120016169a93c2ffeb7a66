package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private final boolean[] Key = new boolean[2];
	private final boolean[] Codes = new boolean[129];

	public void Update() {
		Key[0] = Codes[KeyEvent.VK_ESCAPE];
		Key[1] = Codes[KeyEvent.VK_F10];
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

	public boolean getKey(int i) {
		return Key[i];
	}

	public void setKey(int i, boolean tf) {
		Key[i] = tf;
	}
}