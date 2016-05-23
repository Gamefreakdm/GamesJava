package Input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import Main.Game;

public class InputHandler implements FocusListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	public InputHandler(Game g) {
		game = g;
	}

	public final boolean[] Key = new boolean[68836];

	public void keyPressed(KeyEvent KP) {
		int keyCode = KP.getKeyCode();
		if (keyCode > 0 && keyCode < Key.length)
			Key[keyCode] = true;
	}

	public void keyReleased(KeyEvent KR) {
		int keyCode = KR.getKeyCode();
		if (keyCode > 0 && keyCode < Key.length)
			Key[keyCode] = false;
	}

	public void keyTyped(KeyEvent KT) {
	}

	public void mouseWheelMoved(MouseWheelEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	private final Game game;
	private double pastmx = 0;
	private boolean istr = false;
	private double mousex, mousey, mxc;

	public void mouseMoved(MouseEvent mm) {
		mxc = (mm.getX() - pastmx);
		pastmx = mm.getX();
		setIstr(true);
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
		mousex = arg0.getX();
		mousey = arg0.getY();
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void focusGained(FocusEvent arg0) {
		if (game.GameState() != "Playing")
			game.setGS("Playing");
	}

	public void focusLost(FocusEvent arg0) {
		for (int i = 0; i < Key.length; i++) {
			Key[i] = false;
		}
	}

	public boolean Istr() {
		return istr;
	}

	public void setIstr(boolean t) {
		this.istr = t;
	}

	public double getMousex() {
		return mousex;
	}

	public double getMousey() {
		return mousey;
	}

	public double getMxc() {
		return mxc;
	}
}