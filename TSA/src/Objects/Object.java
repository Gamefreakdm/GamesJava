package Objects;

import java.awt.Graphics;
import Main.ID;

public abstract class Object {
	protected ID id;
	protected int Width;
	protected int Height;
	protected Object OBJ;
	protected short Health;
	protected byte Movement;
	protected byte Direction;
	protected boolean IsMoving;
	protected byte gravitys = 0;
	protected boolean IsCollidingL;
	protected boolean IsCollidingR;
	protected boolean IsCollidingU;
	protected boolean IsCollidingD;
	protected short x, y, VelX, VelY;
	protected boolean IsAlive = false;
	protected boolean Blocked = false;

	public Object(short x, short y, int width, int height, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.Width = width;
		this.Height = height;
	}

	public abstract void Update();

	public abstract void Render(Graphics g);

	public short getX() {
		return x;
	}

	public void setX(short x) {
		this.x = x;
	}

	public short getY() {
		return y;
	}

	public void setY(short y) {
		this.y = y;
	}

	public ID getID() {
		return id;
	}

	public void setID(ID id) {
		this.id = id;
	}

	public short getVelX() {
		return VelX;
	}

	public void setVelX(byte VX) {
		this.VelX = VX;
	}

	public short getVelY() {
		return VelY;
	}

	public void setVelY(byte VY) {
		this.VelY = VY;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int h) {
		Health = (short) h;
	}

	public void kill() {
		IsAlive = false;
	}

	public int getWidth() {
		return Width;
	}

	public int getHeight() {
		return Height;
	}

	public boolean getCollidingL() {
		return IsCollidingL;
	}

	public void setCollidingL(boolean C) {
		IsCollidingL = C;
	}

	public boolean getCollidingR() {
		return IsCollidingR;
	}

	public void setCollidingR(boolean C) {
		IsCollidingR = C;
	}

	public boolean getCollidingU() {
		return IsCollidingU;
	}

	public void setCollidingU(boolean C) {
		IsCollidingU = C;
	}

	public boolean getCollidingD() {
		return IsCollidingD;
	}

	public void setCollidingD(boolean C) {
		IsCollidingD = C;
	}

	public byte getGravitys() {
		return gravitys;
	}

	public void setGravitys(byte gravitys) {
		this.gravitys = gravitys;
	}

	public void setIsAlive(boolean is) {
		this.IsAlive = is;
	}
}