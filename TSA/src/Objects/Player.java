package Objects;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;
import Main.ID;
import Main.Story;

public class Player extends Object {
	public static byte movement;
	public static double Gravity = 2.5;
	public static double SpeedF = 0;

	public Player(short x, short y, int width, int height, ID id) {
		super(x, y, width, height, id);
		movement = 5;
		setGravitys((byte) 3);
		Health = 25;
		IsAlive = true;
	}

	public void Update() {
		if (IsAlive) {
			Movement = movement;
			this.x += this.getVelX();
			this.y += this.getVelY();
			getX();
			getY();
			if (SpeedF <= 1.5)
				for (double i = SpeedF; i < Screen.Cycle; i += 0.5) {
					SpeedF = i;
				}
			switch (gravitys) {
			case 0:
				Gravity = -2.5 - SpeedF;
				if (getX() >= 0 && !IsCollidingL)
					x += Gravity;
				break;
			case 1:
				Gravity = 2.5 + SpeedF;
				if (getX() < 738 && !IsCollidingR)
					x += Gravity;
				break;
			case 2:
				Gravity = -2.5 - SpeedF;
				if (getY() >= 0 && !IsCollidingU)
					y += Gravity;
				break;
			case 3:
				Gravity = 2.5 + SpeedF;
				if (getY() < 512 && !IsCollidingD)
					y += Gravity;
				break;
			}
			switch (Movement) {
			case 0:
				if (x < 1) {
					movement = 5;
				} else {
					setVelX((byte) -3);
				}
				break;
			case 1:
				if (x > 734) {
					movement = 5;
				} else {
					setVelX((byte) 3);
				}
				break;
			case 2:
				if (y > 512) {
					movement = 5;
				} else {
					setVelY((byte) 3);
				}
				break;
			case 3:
				if (y < 0) {
					movement = 5;
				} else {
					setVelY((byte) -3);
				}
				break;
			case 5:
				setVelX((byte) 0);
				setVelY((byte) 0);
				break;
			}
			if (Health <= 0) {
				IsAlive = false;
				Story.Storypart = 4;
			}
		}
	}

	public void Render(Graphics g) {
		if (IsAlive) {
			g.setColor(Color.green);
			g.fillRect(getX(), getY(), getWidth(), getHeight());
			g.setColor(Color.BLACK);
			g.drawString("" + getHealth(), getX() + ((getWidth() / 2) - 5), getY() + (getHeight() / 2));
		}
	}
}