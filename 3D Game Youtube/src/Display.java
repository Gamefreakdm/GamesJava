import java.awt.Canvas;
import javax.swing.JFrame;

public class Display extends Canvas {
	private static final long serialVersionUID = 7262212897609102556L;
	public static final int Width = 800, Height = 600;

	public static void main(String[] args) {
		Display M = new Display();
		JFrame Frame = new JFrame("Loading...");
		Frame.add(M);
		Frame.pack();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setResizable(false);
		Frame.setSize(Width, Height);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
	}
}