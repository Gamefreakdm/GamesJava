import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {
		int room = 0;
		if (room == 0) {
			System.out.println("say yes to move on");
			if (input.hasNext("yes"))
				room = 2;
			else if (input.hasNext("no"))
				System.out.println("You died");
			if (room == 2) {
				System.out.println("do you want to continue?");
			}
		}
	}
}
