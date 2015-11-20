package Objects;

public abstract class Entity {
	private int X, Y;
	private double Vel;
	private boolean IsAlive, IsMoving;

	protected abstract void Render();

	protected abstract void Update();

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public boolean isIsAlive() {
		return IsAlive;
	}

	public void setIsAlive(boolean isAlive) {
		IsAlive = isAlive;
	}

	public boolean isIsMoving() {
		return IsMoving;
	}

	public void setIsMoving(boolean isMoving) {
		IsMoving = isMoving;
	}

	public double getVel() {
		return Vel;
	}

	public void setVel(double vel) {
		Vel = vel;
	}
}