package Objects;

import Base.KeyHandler;
import Base.Main;
import Graphics.Screen;
import Graphics.Sprite;
import Level.Level;

public class Player extends Entity {
	protected int Timer = 0;
	protected int Lives = 3;
	protected double GV = 0;
	protected int level = -1;
	protected boolean Jumping;
	protected KeyHandler Input;
	protected boolean Gravity = true;

	public Player(float x, float y, char Chart, KeyHandler Input) {
		super(x, y, Chart);
		this.Input = Input;
		sprite = Sprite.P1S;
	}

	private void Gravity() {
		if (Gravity) {
			this.GV = 3.5;
			this.y += GV;
		} else
			GV = 0;
	}

	private void Anim() {
		if (Input.RIGHT || Input.LEFT || Input.SPACE)
			IsMoving = true;
		else
			IsMoving = false;
		if (Input.RIGHT && x < Main.Width - 40)
			x += 2.5;
		if (x > 0 && Input.LEFT)
			x -= 2.5;
		if (Input.SPACE && y > 1 && !Jumping && Gravity == false)
			Jumping = true;
		if (Jumping) {
			Gravity = false;
			if (Timer <= 17) {
				y -= 3.5;
				Timer++;
			} else {
				Gravity = true;
				Jumping = false;
			}
		} else
			Timer = 0;
		if (level < 7) {
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
		}
	}

	public void Hit() {
		Lives--;
		this.x = 10;
		this.y = 10;
	}

	public void Render() {
		Anim();
		Screen.RenderP(x, y, sprite);
	}

	public void Update() {
		if (Lives <= 0) {
			if (level <= 3) {
				Main.Score = 0;
				LevelUp(level = 0);
			} else if (level > 3) {
				Main.Score = 16;
				LevelUp(level = 4);
			}
			Lives = 3;
		}
		Gravity();
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

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean getJumping() {
		return Jumping;
	}

	public void setJumping(boolean j) {
		Jumping = j;
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