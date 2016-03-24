package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyHandler implements KeyListener {
	public boolean Keys[] = new boolean[7];
	private final boolean[] Codes = new boolean[400];

	public void Update() {
		Keys[0] = Codes[KeyEvent.VK_ESCAPE];
		Keys[1] = Codes[KeyEvent.VK_UP];
		Keys[2] = Codes[KeyEvent.VK_DOWN];
		Keys[3] = Codes[KeyEvent.VK_LEFT];
		Keys[4] = Codes[KeyEvent.VK_RIGHT];
		Keys[5] = Codes[KeyEvent.VK_SPACE];
		Keys[6] = Codes[KeyEvent.VK_I];
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