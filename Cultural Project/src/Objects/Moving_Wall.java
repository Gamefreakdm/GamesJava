package Objects;

import Level.Wall;

public class Moving_Wall extends Wall {
	private int Time = 0, Timer = 0;
	private char MovePos = 'a';
	private double Movspeed = 0;

	public Moving_Wall(int x, int y, int w, int h, char m, double speed, int time) {
		super(x, y, w, h);
		MovePos = m;
	}

	public void Update() {
		if (MovePos == 'v') {
			Timer++;
			this.y -= 2.5;
			if (Timer >= Time) {
				this.y += 2.5;
				if (Timer >= Time * 2)
					Timer = 0;
			}
			this.y += 2.5;
		} else if (MovePos == 'h') {
		}
	}
}