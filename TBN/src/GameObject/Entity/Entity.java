package GameObject.Entity;

public abstract class Entity {
	private float X, Y;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}
}