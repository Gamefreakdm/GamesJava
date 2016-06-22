package Main;

import Input.KeyHandler;

public class Game {
	private boolean Running = false;

	public Game() {
		Running = true;
	}

	public void Update(KeyHandler KH) {
		KeyUpdate(KH);
	}

	public void KeyUpdate(KeyHandler KH) {
		KH.Update();
		if (KH.Keys[0])
			Running = false;
	}

	public boolean getRunning() {
		return Running;
	}
}