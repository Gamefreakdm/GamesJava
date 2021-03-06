package Objects;

import java.util.LinkedList;
import java.util.Random;

public class ObjectList {
	private static Random random = new Random();
	public static LinkedList<Enemy> Enemys = new LinkedList<Enemy>();
	public static LinkedList<Bullet> gBullets = new LinkedList<Bullet>();
	public static LinkedList<Bullet> bBullets = new LinkedList<Bullet>();
	public static LinkedList<Explosion> EXPS = new LinkedList<Explosion>();

	public static void Update() {
		for (int i = 0; i < gBullets.size(); i++) {
			gBullets.get(i).Update();
		}
		for (int i = 0; i < bBullets.size(); i++) {
			bBullets.get(i).Update();
		}
		for (int i = 0; i < Enemys.size(); i++) {
			Enemys.get(i).Update();
		}
		for (int i = 0; i < EXPS.size(); i++) {
			EXPS.get(i).Update();
		}
	}

	public static void Removeall() {
		gBullets.clear();
		bBullets.clear();
	}

	public static void Render() {
		for (int i = 0; i < gBullets.size(); i++) {
			gBullets.get(i).Render();
		}
		for (int i = 0; i < bBullets.size(); i++) {
			bBullets.get(i).Render();
		}
		for (int i = 0; i < Enemys.size(); i++) {
			Enemys.get(i).Render();
		}
		for (int i = 0; i < EXPS.size(); i++) {
			EXPS.get(i).Render();
		}
	}

	public static void CheckCol() {
		for (int i = 0; i < bBullets.size(); i++) {
			if (bBullets.get(i).getX() < Main.Main.player.getX() + 32 && bBullets.get(i).getY() + 32 > Main.Main.player.getY() && bBullets.get(i).getY() < Main.Main.player.getY() + 32) {
				Main.Main.player.setHealth(5);
				removeBulletb(bBullets.get(i));
			}
		}
		for (int i = 0; i < Enemys.size(); i++) {
			for (int b = 0; b < gBullets.size(); b++) {
				if (gBullets.get(b).getX() < Enemys.get(i).getX() + 32 && gBullets.get(b).getX() + 32 > Enemys.get(i).getX() && gBullets.get(b).getY() < Enemys.get(i).getY() + 32 && gBullets.get(b).getY() + 32 > Enemys.get(i).getY()) {
					addEX(new Explosion(Enemys.get(i).getX(), Enemys.get(i).getY()));
					removeBullet(gBullets.get(b));
					removeEnemy(Enemys.get(i));
					Main.Main.setScore(1);
					Main.Main.ScoreUp();
					addEnemy(new Enemy(random.nextInt(400) * 2 + 500, random.nextInt(400) * 2));
					i = 0;
					b = 0;
				}
			}
		}
	}

	public static void addBullet(Bullet b) {
		gBullets.add(b);
	}

	public static void addBulletb(Bullet b) {
		bBullets.add(b);
	}

	public static void addEnemy(Enemy e) {
		Enemys.add(e);
	}

	public static void addEX(Explosion e) {
		EXPS.add(e);
	}

	public static void removeBullet(Bullet b) {
		gBullets.remove(b);
	}

	public static void removeBulletb(Bullet b) {
		bBullets.remove(b);
	}

	public static void removeEnemy(Enemy e) {
		Enemys.remove(e);
	}

	public static void removeEX(Explosion e) {
		EXPS.remove(e);
	}
}