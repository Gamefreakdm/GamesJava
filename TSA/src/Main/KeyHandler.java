package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Graphics.Screen;
import Objects.Player;

public class KeyHandler implements KeyListener {

	public void keyPressed(KeyEvent KP) {
		short keyCode = (short) KP.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE)
			System.exit(0);
		if (keyCode == KeyEvent.VK_A && Screen.player.getGravitys() != 1 && Screen.player.getGravitys() != 0 && Screen.player.getCollidingR() == false)
			Player.movement = 0;
		if (keyCode == KeyEvent.VK_D && Screen.player.getGravitys() != 1 && Screen.player.getGravitys() != 0)
			Player.movement = 1;
		if (keyCode == KeyEvent.VK_W && Screen.player.getGravitys() != 2 && Screen.player.getGravitys() != 3)
			Player.movement = 3;
		if (keyCode == KeyEvent.VK_S && Screen.player.getGravitys() != 2 && Screen.player.getGravitys() != 3)
			Player.movement = 2;
		if (keyCode == KeyEvent.VK_UP)
			Screen.player.setGravitys((byte) 2);
		if (keyCode == KeyEvent.VK_DOWN)
			Screen.player.setGravitys((byte) 3);
		if (keyCode == KeyEvent.VK_LEFT)
			Screen.player.setGravitys((byte) 0);
		if (keyCode == KeyEvent.VK_RIGHT)
			Screen.player.setGravitys((byte) 1);
		if (keyCode == KeyEvent.VK_SPACE && Story.Storypart <= 2 || keyCode == KeyEvent.VK_SPACE && Story.Storypart == 5)
			Story.Storypart++;
		if (keyCode == KeyEvent.VK_K)
			Screen.player.setHealth(0);
	}

	public void keyReleased(KeyEvent KR) {
		short keyCode = (short) KR.getKeyCode();
		if (keyCode == KeyEvent.VK_A)
			Player.movement = 5;
		if (keyCode == KeyEvent.VK_D)
			Player.movement = 5;
		if (keyCode == KeyEvent.VK_W)
			Player.movement = 5;
		if (keyCode == KeyEvent.VK_S)
			Player.movement = 5;
	}

	public void keyTyped(KeyEvent KT) {
		@SuppressWarnings("unused")
		short keyCode = (short) KT.getKeyCode();
	}
}