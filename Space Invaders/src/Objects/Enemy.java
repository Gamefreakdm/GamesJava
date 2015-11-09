package Objects;

import java.util.Random;
import Graphics.Sprite;

public class Enemy extends Entity {
	protected int Dir;
	protected Random random = new Random();
	protected int FireTimer = 0;
	protected int FireTick = 0;
	protected Sprite sps, spu, spd, spf;

	public Enemy(int X, int Y) {
		this.setX(X);
		this.setY(Y);
		this.setVel(3.0);
		spu = Sprite.Enemy_Up;
		spd = Sprite.Enemy_Down;
		spf = Sprite.Enemy_Still;
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
			spf = spd;
			if (this.getY() < Main.Main.HEight - 32)
				this.setY((int) (this.getY() + this.getVel()));
			else
				Dir = 1;
			break;
		case 1:
			spf = spu;
			if (this.getY() > 0)
				this.setY((int) (this.getY() - this.getVel()));
			else
				Dir = 0;
			break;
		}

	}
}