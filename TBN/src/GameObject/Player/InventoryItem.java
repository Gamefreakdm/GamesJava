package GameObject.Player;

import Graphics.Image.Sprite;

public class InventoryItem {
	private int x = 0;
	private int y = 0;
	private final Sprite sprite;

	public InventoryItem(int sn, Sprite sp) {
		sprite = sp;
	}
	// TODO:Inventory Item

	public void Update() {
	}

	public void Render() {
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}