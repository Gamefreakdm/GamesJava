package Main;

import java.awt.event.KeyEvent;
import Input.Controller;

public class Game {
	private double Time = 0;
	public final Controller CO;
	private boolean Running = false;

	public Game() {
		Running = true;
		CO = new Controller();
	}

	public void KeyUpdate(boolean[] key) {
		if (key[KeyEvent.VK_ESCAPE])
			Running = false;
		boolean l = key[KeyEvent.VK_A];
		boolean r = key[KeyEvent.VK_D];
		boolean fw = key[KeyEvent.VK_W];
		boolean bw = key[KeyEvent.VK_S];
		boolean tl = key[KeyEvent.VK_LEFT];
		boolean tr = key[KeyEvent.VK_RIGHT];
		CO.Update(fw, bw, l, r, tl, tr);
	}

	public void Update() {
		Time++;
	}

	public double getTime() {
		return Time;
	}

	public boolean IsRunning() {
		return Running;
	}
}