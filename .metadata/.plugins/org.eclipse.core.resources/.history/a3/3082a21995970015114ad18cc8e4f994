package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	public boolean[] Keys = new boolean[2];
	private final boolean[] Codes = new boolean[129];

	public void Update() {
		Keys[1] = Codes[KeyEvent.VK_ESCAPE];
		for (int i = 0; i < Keys.length; i++) {
			if (Keys[i] == true)
				Keys[0] = true;
			else
				Keys[0] = false;
		}
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