package Main;

import javax.swing.JFrame;
import Graphics.Render.Screen;
import Input.InputHandler;

public class Game {
	private String gs;
	private double Time = 0;

	public void Update(InputHandler IH, JFrame frame) {
		frame.requestFocus();
		KeyUpdate(IH);
	}

	private void KeyUpdate(InputHandler IH) {
	}

	public void Render(Screen sc) {
	}

	public double getTime() {
		return Time;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}
}