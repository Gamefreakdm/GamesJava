package Objects;

public class Explosion extends Entity {
	protected int Timer = 0;

	public Explosion(float f, float g) {
		this.setX(f);
		this.setY(g);
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