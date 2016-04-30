package Entity;

public class Entity {
	private float X, Y;
	private boolean IsAlive;

	public Entity(float x, float y) {
		X = x;
		Y = y;
	}

	public float getX() {
		return X;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}

	public boolean isIsAlive() {
		return IsAlive;
	}

	public void setIsAlive(boolean isAlive) {
		IsAlive = isAlive;
	}
}
