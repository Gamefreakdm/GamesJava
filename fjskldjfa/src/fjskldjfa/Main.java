package fjskldjfa;

import javax.swing.JFrame;

public class Main {
	private final JFrame Frame;
	private final int Width, Height;

	public Main() {
		Width = 800;
		Height = 600;
		Frame = new JFrame("Loading...");
	}

	public static void main(String args[]) {
		Main main = new Main();
		main.Frame.setSize(main.Width, main.Height);
		main.Frame.setLocationRelativeTo(null);
		main.Frame.setVisible(true);
		main.Update();
	}

	private void Update() {
	}

	private void Render() {
	}

	public void run() {
	}
}
