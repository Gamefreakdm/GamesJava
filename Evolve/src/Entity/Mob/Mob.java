package Entity.Mob;

import java.awt.Graphics;
import java.util.Random;

import Entity.Entity;

public abstract class Mob extends Entity {
	protected boolean Moving = false;
	protected boolean Speaking = false;
	protected int SpeakTimer = 0;
	protected int MovementTimer = 0;

	public void Move(int xa, int ya) {
		if (xa > 0)
			setDir(1);
		if (xa < 0)
			setDir(3);
		if (ya > 0)
			setDir(2);
		if (ya < 0)
			setDir(0);
		if (getDir() == 1 && getX() < 1379)
			setX((getX() + xa));
		if (getDir() == 3 && getX() > 26.0)
			setX((getX() + xa));
		if (getDir() == 2 && getY() < 1377)
			setY((getY() + ya));
		if (getDir() == 0 && getY() > 32.0)
			setY((getY() + ya));
	}

	public void Update() {
		Random random = new Random();
		if (this.SpeakTimer == 0)
			Speaking = random.nextBoolean();
	}

	public void Render() {
	}

	public void Speak(Graphics g) {
	}
}