package Objects;

import java.awt.Color;
import java.awt.Graphics;
import Graphics.Screen;
import Main.ID;

public class Wall extends Object {
	protected byte side;
	protected int Timer = 0;
	protected int pastmovement = 4;
	protected boolean IsBad = false;

	public Wall(short x, short y, int width, int height, boolean isbad, byte side, ID id) {
		super(x, y, width, height, id);
		IsBad = isbad;
		this.side = side;
		Movement = side;
		IsAlive = true;
	}

	public void Update() {
		if (IsAlive) {
			x += getVelX();
			y += getVelY();
			if (Screen.Cycle <= 4 && this.id == ID.Wall4 || Screen.Cycle <= 4 && this.id == ID.Wall10)
				Movement = 4;
			if (Screen.player.getX() + Screen.player.getWidth() >= getX() && Screen.player.getX() + Screen.player.getWidth() < getX() + 10 && Screen.player.getY() + Screen.player.getHeight() >= getY() && Screen.player.getY() <= getY() + Height) {
				if (IsBad) {
					Screen.player.setHealth(Screen.player.getHealth() - 1);
					Screen.player.setX((short) (getX() - 60 - 1));
					Screen.player.setGravitys((byte) 2);
					System.out.println(this.id);
				}
				Screen.player.setCollidingR(true);
				setCollidingR(true);
				Screen.player.setX((short) (getX() - 60 - 1));
			} else
				setCollidingR(false);
			if (Screen.Wall0.getCollidingR() != true && Screen.Wall1.getCollidingR() != true && Screen.Wall2.getCollidingR() != true && Screen.Wall3.getCollidingR() != true && Screen.Wall4.getCollidingR() != true && Screen.Wall5.getCollidingR() != true && Screen.Wall6.getCollidingR() != true && Screen.Wall7.getCollidingR() != true && Screen.Wall8.getCollidingR() != true && Screen.Wall9.getCollidingR() != true && Screen.Wall10.getCollidingR() != true)
				Screen.player.setCollidingR(false);

			if (Screen.player.getX() <= getX() + Width && Screen.player.getX() > getX() + getWidth() - 10 && Screen.player.getY() + Screen.player.getHeight() >= getY() && Screen.player.getY() <= getY() + Height) {
				if (IsBad) {
					Screen.player.setHealth(Screen.player.getHealth() - 1);
					Screen.player.setX((short) (getX() + Width + 60 + 1));
					Screen.player.setGravitys((byte) 1);
				}
				Screen.player.setCollidingL(true);
				setCollidingL(true);
				Screen.player.setX((short) (getX() + Width + 1));
			} else
				setCollidingL(false);
			if (Screen.Wall0.getCollidingL() != true && Screen.Wall1.getCollidingL() != true && Screen.Wall2.getCollidingL() != true && Screen.Wall3.getCollidingL() != true && Screen.Wall4.getCollidingL() != true && Screen.Wall5.getCollidingL() != true && Screen.Wall6.getCollidingL() != true && Screen.Wall6.getCollidingL() != true && Screen.Wall8.getCollidingL() != true && Screen.Wall9.getCollidingL() != true && Screen.Wall10.getCollidingL() != true)
				Screen.player.setCollidingL(false);

			if (Screen.player.getY() + Screen.player.getHeight() >= getY() && Screen.player.getY() + Screen.player.getHeight() <= getY() + 10 && Screen.player.getX() + Screen.player.getWidth() >= getX() && Screen.player.getX() <= getX() + Width) {

				if (id == ID.WinL) {
					Screen.Cycle += 1;
					Screen.player.setGravitys((byte) 3);
					Screen.player.setY((short) (Screen.player.getY() + Screen.player.getWidth() + 10));
				} else {
					Screen.player.setCollidingD(true);
					setCollidingD(true);
					Screen.player.setY((short) (getY() - 60 - 1));
				}
				if (IsBad) {
					Screen.player.setHealth(Screen.player.getHealth() - 1);
					Screen.player.setY((short) (getY() - 60 - 1));
					Screen.player.setGravitys((byte) 1);
				}
			} else
				setCollidingD(false);
			if (Screen.Wall0.getCollidingD() != true && Screen.Wall1.getCollidingD() != true && Screen.Wall2.getCollidingD() != true && Screen.Wall3.getCollidingD() != true && Screen.Wall4.getCollidingD() != true && Screen.Wall5.getCollidingD() != true && Screen.Wall6.getCollidingD() != true && Screen.Wall7.getCollidingD() != true && Screen.Wall8.getCollidingD() != true && Screen.Wall9.getCollidingD() != true && Screen.Wall10.getCollidingD() != true && Screen.WinLine.getCollidingD() != true)
				Screen.player.setCollidingD(false);

			if (Screen.player.getY() <= getY() + Height && Screen.player.getY() >= getY() + getHeight() - 10 && Screen.player.getX() + Screen.player.getWidth() >= getX() && Screen.player.getX() <= getX() + Width) {
				if (id == ID.WinL) {
					Screen.player.setGravitys((byte) 3);
				}
				if (IsBad) {
					Screen.player.setHealth(Screen.player.getHealth() - 1);
					Screen.player.setY((short) (getY() + getHeight() + 1));
					Screen.player.setGravitys((byte) 0);
				}
				Screen.player.setCollidingU(true);
				setCollidingU(true);
				Screen.player.setY((short) (getY() + getHeight() + 1));
			} else
				setCollidingU(false);
			if (Screen.Wall0.getCollidingU() != true && Screen.Wall1.getCollidingU() != true && Screen.Wall2.getCollidingU() != true && Screen.Wall3.getCollidingU() != true && Screen.Wall4.getCollidingU() != true && Screen.Wall5.getCollidingU() != true && Screen.Wall6.getCollidingU() != true && Screen.Wall7.getCollidingU() != true && Screen.Wall8.getCollidingU() != true && Screen.Wall9.getCollidingU() != true && Screen.Wall10.getCollidingU() != true)
				Screen.player.setCollidingU(false);
			switch (Movement) {
			case 0:
				Timer++;
				pastmovement = Movement;
				if (side <= 1 && IsBad) {
					if (Timer <= 60)
						setVelX((byte) -1);
					else {
						Movement = 4;
						Timer = 0;
						break;
					}
				}
				break;
			case 1:
				Timer++;
				pastmovement = Movement;
				if (side <= 1 && IsBad)
					if (Timer <= 60) {
						setVelX((byte) 1);
					} else {
						Movement = 4;
						Timer = 0;
						break;
					}
				break;
			case 2:
				Timer++;
				pastmovement = Movement;
				if (side <= 3 && side >= 2 && IsBad)
					if (Timer <= 60) {
						setVelY((byte) 1);
					} else {
						Movement = 4;
						Timer = 0;
						break;
					}
				break;
			case 3:
				Timer++;
				pastmovement = Movement;
				if (side <= 3 && side >= 2 && IsBad)
					if (Timer <= 60) {
						setVelY((byte) -1);
					} else {
						Movement = 4;
						Timer = 0;
						break;
					}
				break;
			case 4:
				Timer++;
				if (Timer <= 25) {
					if (side <= 1)
						setVelX((byte) 0);
					if (side >= 2)
						setVelY((byte) 0);
				} else {
					Timer = 0;
					if (pastmovement == 0)
						Movement = 1;
					else if (pastmovement == 1)
						Movement = 0;
					else if (pastmovement == 2)
						Movement = 3;
					else
						Movement = 2;
					break;
				}
				break;
			}
		}
	}

	public void Render(Graphics g) {
		if (IsAlive) {
			if (id == ID.WinL) {
				g.setColor(Color.YELLOW);
				g.fillRect(getX(), getY(), getWidth(), getHeight());
			}
			if (IsBad)
				g.setColor(Color.RED);
			else if (!IsBad && id != ID.WinL)
				g.setColor(Color.BLUE);
			g.fillRect(getX(), getY(), Width, Height);
		}
	}
}