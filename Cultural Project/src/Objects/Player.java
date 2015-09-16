package Objects;

import Base.KeyHandler;
import Base.Main;
import Graphics.Screen;
import Graphics.Sprite;
import Level.Level;

public class Player extends Entity {
	protected int level = -1;
	protected int Timer = 0;
	protected boolean Jumping;
	protected boolean Gravity = true;
	protected KeyHandler Input;
	protected int Lives = 3;

	public Player(int x, int y, char Chart, KeyHandler Input) {
		super(x, y, Chart);
		this.Input = Input;
		sprite = Sprite.P1S;
	}

	public void Anim() {
		if (Gravity)
			y += 2.5;
		if (Input.RIGHT || Input.LEFT || Input.SPACE)
			IsMoving = true;
		else
			IsMoving = false;
		if (Input.RIGHT && x < Main.Width - 40)
			x += 2.5;
		if (x > 0 && Input.LEFT)
			x -= 2;
		if (Input.SPACE && y > 1 && !Jumping && Gravity == false)
			Jumping = true;
		if (Jumping) {
			Gravity = false;
			if (Timer <= 30) {
				y -= 3.5;
				Timer++;
			} else {
				Gravity = true;
				Jumping = false;
			}
		} else
			Timer = 0;
		switch (level) {
		case 0:
			if (!IsMoving)
				sprite = Sprite.P1S;
			else {
				if (Input.RIGHT) {
					if (AnimN % 25 > 15)
						sprite = Sprite.P1MR;
					else
						sprite = Sprite.P1SR;
				}
				if (Input.LEFT) {
					if (AnimN % 25 > 15)
						sprite = Sprite.P1ML;
					else
						sprite = Sprite.P1SL;
				}
			}
			break;
		case 1:
			if (!IsMoving)
				sprite = Sprite.P1S;
			else {
				if (Input.RIGHT) {
					if (AnimN % 25 > 15)
						sprite = Sprite.P1MR;
					else
						sprite = Sprite.P1SR;
				}
				if (Input.LEFT) {
					System.out.println("sdsad");
					if (AnimN % 25 > 15)
						sprite = Sprite.P1ML;
					else
						sprite = Sprite.P1SL;
				}
			}
			break;
		}
	}

	public void Render() {
		Anim();
		Screen.RenderP(x, y, sprite);
	}

	public void Update() {
		if (AnimN < 7500)
			AnimN++;
		else
			AnimN = 0;
	}

	public void LevelUp(int l) {
		this.level = l;
		Level.createLevel(getLevel());
	}

	public int getLevel() {
		return this.level;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean getJumping() {
		return Jumping;
	}

	public void setGravity(boolean g) {
		Gravity = g;
	}

	public void setLives(int l) {
		this.Lives = l;
	}

	public int getLives() {
		return Lives;
	}
}