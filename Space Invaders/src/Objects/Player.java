package Objects;

import Graphics.Sprite;
import Main.KeyHandler;

public class Player extends Entity {
	protected Sprite sps, spu, spd, spf;
	protected KeyHandler KH;
	protected int Health = 100;

	public Player(int x, int y, KeyHandler KH) {
		this.setWidth(32);
		this.setHeight(32);
		this.sps = Sprite.Player_Still;
		this.spd = Sprite.Player_Down;
		this.spu = Sprite.Player_Up;
		this.spf = sps;
		this.setVel(3.5);
		this.KH = KH;
	}

	public void Update() {
		if (KH.Keys[2] && this.getY() > 0) {
			this.setY((int) (this.getY() - this.getVel()));
			spf = spu;
		}
		if (KH.Keys[3] && this.getY() + 32 < Main.Main.HEight) {
			this.setY((int) (this.getY() + this.getVel()));
			spf = spd;
		}
		if (!KH.Keys[2] && !KH.Keys[3])
			spf = sps;

		if (this.getHealth() <= 0) {
			ObjectList.addEX(new Explosion(this.getX(), this.getY()));
			Main.Main.RestartGame();
		}
	}

	public void Render() {
		Main.Main.screen.RenderPlayer(getX(), getY(), spf);
	}

	public void setHealth(int D) {
		Health -= D;
	}

	public int getHealth() {
		return Health;
	}
}