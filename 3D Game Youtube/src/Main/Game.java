package Main;

import java.awt.event.KeyEvent;
import Input.Controller;

public class Game {
	private static String GS;
	private final Controller CO;
	private boolean Running = false;

	public Game() {
		Running = true;
		CO = new Controller();
		GS = "Playing";
	}

	private double Time = 0;
	private double pTime = 0;

	public void KeyUpdate(boolean[] key, double mxos, boolean istr) {
		if (GS == "Playing") {
			if (key[KeyEvent.VK_ESCAPE]) {
				GS = "Paused";
				pTime = Time;
			}
			boolean a = key[KeyEvent.VK_A];
			boolean d = key[KeyEvent.VK_D];
			boolean w = key[KeyEvent.VK_W];
			boolean s = key[KeyEvent.VK_S];
			boolean crl = key[KeyEvent.VK_CONTROL];
			boolean shi = key[KeyEvent.VK_SHIFT];
			boolean ju = key[KeyEvent.VK_SPACE];
			CO.Update(w, s, a, d, istr, mxos, crl, shi, ju);
		} else if (GS == "Paused") {
			if (key[KeyEvent.VK_ENTER])
				GS = "Playing";
			if (key[KeyEvent.VK_ESCAPE] && pTime > Time + 9)
				Running = false;
		}
	}

	public void Update() {
		if (GS == "Playing")
			Time++;
		else if (GS == "Paused")
			pTime++;
	}

	public double getTime() {
		return Time;
	}

	public boolean IsRunning() {
		return Running;
	}

	public String GameState() {
		return GS;
	}

	public void setGS(String g) {
		GS = g;
	}

	public Controller getCO() {
		return CO;
	}
}