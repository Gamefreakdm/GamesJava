package Input;

public class Controller {
	private boolean ju = false;
	private double x, y, z, rot, xa, za, rota, pastmxos;

	public void Update(boolean fw, boolean bw, boolean l, boolean r, boolean istr, double nmxos, boolean spr, boolean cro, boolean ju) {
		double xMove = 0;
		double zMove = 0;
		final double RotSpeed = 600.00;
		final double juh = 0.8;
		final double crouh = 0.5;
		if (nmxos != pastmxos && istr)
			rota += nmxos / RotSpeed;
		double WalkSpeed;
		if (spr)
			WalkSpeed = 2.0;
		else if (cro)
			WalkSpeed = 0.6;
		else
			WalkSpeed = 1.4;
		if (fw)
			zMove += WalkSpeed;
		if (bw)
			zMove -= WalkSpeed;
		if (r)
			xMove += WalkSpeed;
		if (l)
			xMove -= WalkSpeed;
		if (ju)
			y += juh;
		if (cro)
			y -= crouh;
		xa = (((xMove * Math.cos(rot)) + (zMove * Math.sin(rot))) * WalkSpeed);
		za = (((zMove * Math.cos(rot)) - (xMove * Math.sin(rot))) * WalkSpeed);
		x = (getX() + xa);
		y *= 0.9;
		z = (getZ() + za);
		xa *= 0.1;
		za *= 0.1;
		rot += rota;
		rota *= 0.8;
		this.ju = ju;
	}

	public double getX() {
		return x;
	}

	public double getZ() {
		return z;
	}

	public double getRot() {
		return rot;
	}

	public boolean getju() {
		return ju;
	}

	public double getY() {
		return y;
	}
}