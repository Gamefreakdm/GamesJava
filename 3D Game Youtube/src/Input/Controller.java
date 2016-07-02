package Input;

public class Controller {
	private double x, z, rot, xa, za, rota, pastmxos;

	public void Update(boolean fw, boolean bw, boolean l, boolean r, boolean istr, double nmxos, boolean spr, boolean cro) {
		double xMove = 0;
		double zMove = 0;
		double RotSpeed = 600.00;
		if (nmxos != pastmxos && istr)
			rota += nmxos / RotSpeed;
		double WalkSpeed;
		if (spr)
			WalkSpeed = 2.0;
		else if (cro)
			WalkSpeed = 0.2;
		else
			WalkSpeed = 1.0;
		if (fw)
			zMove += WalkSpeed;
		if (bw)
			zMove -= WalkSpeed;
		if (r)
			xMove += WalkSpeed;
		if (l)
			xMove -= WalkSpeed;
		xa = (((xMove * Math.cos(rot)) + (zMove * Math.sin(rot))) * WalkSpeed);
		za = (((zMove * Math.cos(rot)) - (xMove * Math.sin(rot))) * WalkSpeed);
		x = (getX() + xa);
		z = (getZ() + za);
		xa *= 0.1;
		za *= 0.1;
		rot += rota;
		rota *= 0.8;
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
}