package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Story {
	public static String Text1;
	public static String Text2;
	public static String Text3;
	public static String Text4;
	public static String Text5;
	public static int Storypart = 0;
	public static boolean showText = true;

	public static void Update() {
		switch (Storypart) {
		case 0:
			Text1 = "In this game you will face many challenges such as moving walls.";
			Text2 = "You must avoid these obstacles by changing you gravity and moving around int the mazes.";
			Text3 = "To move the player use W to move up when not against gravity use S to move downwords when not against gravity.";
			Text4 = "Use D to move Right while not against gravity and use A to move Left while not against gravity.";
			Text5 = "Press SPACE to continue";
			break;
		case 1:
			Text1 = "Use the arrow keys to change teh players gravity, but be careful the gravity can kill you and save you.";
			Text2 = "As you go on the maze will get harder and harder.";
			Text3 = "Blue Walls are safe to touch and red will take a life way.";
			Text4 = "Touch the yellow line to complete a cicle";
			Text5 = "Press SPACE to start";
			break;
		case 2:
			showText = false;
			break;
		case 5:
			showText = true;
			Text1 = "You died";
			Text2 = "";
			Text3 = "";
			Text4 = "";
			Text5 = "Press SPACE to play again";
			break;
		case 6:
			Storypart = 0;
			break;
		}
	}

	public static void Render(Graphics g) {
		if (showText) {
			g.setColor(Color.black);
			g.fillRect(0, 500, 800, 100);
			g.setColor(Color.white);
			g.drawString(Text1, 20, 510);
			g.drawString(Text2, 20, 525);
			g.drawString(Text3, 20, 540);
			g.drawString(Text4, 20, 555);
			g.drawString(Text5, 20, 570);
		}
	}
}