package Input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyHandler extends GLFWKeyCallback {
	private static boolean[] Keys = new boolean[65536];

	public void invoke(long window, int key, int scancode, int action, int mods) {
		Keys[key] = action != GLFW.GLFW_RELEASE;
	}
}