package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyHandler implements KeyListener {
	public boolean Up, Down, Left, Right, ESC, SPACE;
	private final boolean[] Codes = new boolean[400];

	public void Update() {
		Up = Codes[KeyEvent.VK_UP];
		Down = Codes[KeyEvent.VK_DOWN];
		Left = Codes[KeyEvent.VK_LEFT];
		Right = Codes[KeyEvent.VK_RIGHT];
		ESC = Codes[KeyEvent.VK_ESCAPE];
		SPACE = Codes[KeyEvent.VK_SPACE];
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