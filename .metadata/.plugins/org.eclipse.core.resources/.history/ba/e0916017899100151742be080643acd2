package Objects;

public class Explosion extends Entity {
	protected int Timer = 0;

	public Explosion(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	protected void Render() {
		Main.Main.screen.DrawExlosion(getX(), getY());
	}

	protected void Update() {
		Timer++;
		if (Timer >= 30)
			ObjectList.removeEX(this);
	}
}