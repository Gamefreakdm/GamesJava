package Objects;

import Graphics.Sprite;

public class Entity {
	protected int x, y;
	protected char Chart;
	protected int AnimN = 0;
	protected Sprite sprite;
	protected boolean IsMoving;

	public Entity(int x, int y, char Chart) {
		this.x = x;
		this.y = y;
		this.Chart = Chart;
	}

	public void Render() {
	}

	public void Update() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}