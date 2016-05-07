package Input;

public class Controller {
	private double x, z, rot, xa, za, rota;

	public void Update(boolean fw, boolean bw, boolean l, boolean r, boolean tl, boolean tr) {
		double RotSpeed = 1;
		double WalkSpeed = 1;
		double xMove = 0;
		double zMove = 0;
		if (fw)
			zMove++;
		if (bw)
			zMove--;
		if (r)
			xMove++;
		if (l)
			xMove--;
		if (tr)
			rota += RotSpeed;
		if (tl)
			rota -= RotSpeed;
		xa = ((xMove * Math.cos(rot)) + (zMove * Math.sin(rot))) * WalkSpeed;
		za = ((zMove * Math.cos(rot)) - (xMove * Math.sin(rot))) * WalkSpeed;
		x += xa;
		z += za;
		xa *= 0.1;
		za *= 0.1;
		rot += rota;
		rota *= 0.8;
	}
}