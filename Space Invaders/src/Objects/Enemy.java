package Objects;

import java.util.Random;
import Graphics.Sprite;

public class Enemy extends Entity {
	private int Dir;
	private int FireTick = 0;
	private int FireTimer = 0;
	private Sprite sps, spm, spf;
	private Random random = new Random();

	public Enemy(int X, int Y) {
		this.setX(X);
		this.setY(Y);
		this.setVel(3.0);
		this.spm = Sprite.Enemy_Moving;
		this.sps = Sprite.Enemy_Still;
		this.spf = sps;
		FireTick = random.nextInt(1200);
		if (FireTick < 400)
			FireTick += 200;
	}

	protected void Render() {
		Main.Main.screen.RenderEnemy(getX(), getY(), spf);
	}

	protected void Update() {
		FireTimer++;
		if (FireTimer >= FireTick) {
			ObjectList.addBulletb(new Bullet(this.getX(), this.getY(), 'b'));
			FireTimer = 0;
		}
		switch (Dir) {
		case 0:
			spf = spm;
			if (this.getY() < Main.Main.HEight - 32)
				this.setY((int) (this.getY() + this.getVel()));
			else
				Dir = 1;
			break;
		case 1:
			spf = spm;
			if (this.getY() > 101)
				this.setY((int) (this.getY() - this.getVel()));
			else
				Dir = 0;
			break;
		}

	}
}