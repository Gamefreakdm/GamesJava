
public class Octorok {
	private float x, y;
	private int Color = 0;
	private static Octorok oct1 = new Octorok();
	private static Octorok oct2 = new Octorok();

	public static void main(String args[]) {
		oct1.initOct();
		oct2.initOct();
		while (1 == 1) {
			oct1.MoveOct();
			oct2.MoveOct();
			oct1.PrintInfo();
			oct2.PrintInfo();
		}
	}

	private void initOct() {
		x = 10;
		y = 10000;
		Color = 0xFF00FF;
	}

	private void ShootRock() {
		System.out.println("Pew Pew");
	}

	private void MoveOct() {
		x += 200;
		y += 200;
	}

	private void PrintInfo() {
		System.out.println("X: " + x + ", Y: " + y);
		System.out.println("Color: " + Color);
	}
}