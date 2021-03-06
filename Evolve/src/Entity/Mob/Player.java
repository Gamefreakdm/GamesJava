package Entity.Mob;

import Graphics.Screen;
import Graphics.Sprite;
import Level.Level;
import Main.KeyHandler;

public class Player extends Mob {
	private String Char;
	private int anim = 0;
	private KeyHandler Input;

	public Player(float x, float y, KeyHandler input, String Char) {
		this.setX(x);
		this.setY(y);
		this.Input = input;
		this.Char = Char;
	}

	public void Update() {
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (Input.Up && !Input.Down && !Input.Left && !Input.Right)
			ya--;
		if (Input.Down && !Input.Up && !Input.Left && !Input.Right)
			ya++;
		if (Input.Left && !Input.Right && !Input.Up && !Input.Down)
			xa--;
		if (Input.Right && !Input.Left && !Input.Up && !Input.Down)
			xa++;

		if (xa != 0 || ya != 0) {
			Move(xa, ya);
			Moving = true;
		} else
			Moving = false;
	}

	public void Render() {
		Animate(Char);
		Screen.RenderPlayer(getX(), getY(), sprite);
	}

	private void Animate(String Char) {
		switch (Char) {
		case "Farm":
			if (getDir() == 1) {
				sprite = Sprite.Player_FR2;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_FR1;
					else
						sprite = Sprite.Player_FR2;
			}
			if (getDir() == 3) {
				sprite = Sprite.Player_FR3;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_FR4;
					else
						sprite = Sprite.Player_FR3;
			}
			if (getDir() == 2) {
				sprite = Sprite.Player_FR7;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_FR8;
					else
						sprite = Sprite.Player_FR7;
			}
			if (getDir() == 0) {
				sprite = Sprite.Player_FR5;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_FR6;
					else
						sprite = Sprite.Player_FR5;
			}
			break;
		case "Gen":
			if (getDir() == 1) {
				sprite = Sprite.Player_GR2;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_GR1;
					else
						sprite = Sprite.Player_GR2;
			}
			if (getDir() == 3) {
				sprite = Sprite.Player_GR3;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_GR4;
					else
						sprite = Sprite.Player_GR3;
			}
			if (getDir() == 2) {
				sprite = Sprite.Player_GR7;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_GR8;
					else
						sprite = Sprite.Player_GR7;
			}
			if (getDir() == 0) {
				sprite = Sprite.Player_GR5;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_GR6;
					else
						sprite = Sprite.Player_GR5;
			}
			break;
		case "Sol":
			if (getDir() == 1) {
				sprite = Sprite.Player_SR2;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_SR1;
					else
						sprite = Sprite.Player_SR2;
			}
			if (getDir() == 3) {
				sprite = Sprite.Player_SR3;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_SR4;
					else
						sprite = Sprite.Player_SR3;
			}
			if (getDir() == 2) {
				sprite = Sprite.Player_SR7;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_SR8;
					else
						sprite = Sprite.Player_SR7;
			}
			if (getDir() == 0) {
				sprite = Sprite.Player_SR5;
				if (Moving)
					if (anim % 25 > 15)
						sprite = Sprite.Player_SR6;
					else
						sprite = Sprite.Player_SR5;
			}
			break;
		}
	}
}