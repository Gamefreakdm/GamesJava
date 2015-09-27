package Objects;

import Base.Main;
import Level.Wall;

public class Moving_Wall extends Wall {
	protected char MovePos = 'a';
	protected double Movspeed = 0;
	protected char PN = 'p';
	protected int Time = 0, Timer = 0;

	public Moving_Wall(float x, float y, int w, int h, char m, double speed, int time) {
		super(x, y, w, h);
		MovePos = m;
		Time = time;
		Movspeed = speed;
	}

	public void Update() {
		Timer++;
		if (MovePos == 'v') {
			switch (PN) {
			case 'n':
				if (Timer <= Time) {
					this.y -= Movspeed;
				} else {
					PN = 'p';
					Timer = 0;
				}

				break;
			case 'p':
				if (Timer <= Time) {
					this.y += Movspeed;
				} else {
					PN = 'n';
					Timer = 0;
				}
			}
		} else {
			switch (PN) {
			case 'n':
				if (Timer <= Time) {
					this.x -= Movspeed;
				} else {
					PN = 'p';
					Timer = 0;
				}

				break;
			case 'p':
				if (Timer <= Time) {
					this.x += Movspeed;
				} else {
					PN = 'n';
					Timer = 0;
				}
			}
		}
	}

	public boolean CheckCol(float x, float y, int w, int h) {
		if (x + w - 5 >= this.getX() && x + 5 <= this.getX() + this.getWidth() && y + h >= this.getY() && y + h <= this.getY() + (this.getHeight() - 1)) {
			Main.player.setGravity(false);
			switch (MovePos) {
			case 'v':
				if (PN == 'n')
					Main.player.setY((float) (Main.player.getY() - Movspeed));
				else
					Main.player.setY((float) (Main.player.getY() + Movspeed));
				break;
			}
			return true;
		} else if (y <= this.getY() + this.getHeight() && y >= this.getY() + this.getHeight() - this.getHeight() / 2 && x + w - 5 >= this.getX() + 1 && x + 5 <= this.getX() + this.getWidth()) {
			Main.player.setJumping(false);
			Main.player.setGravity(true);
			return true;
		}
		Main.player.setGravity(true);
		return false;
	}
}