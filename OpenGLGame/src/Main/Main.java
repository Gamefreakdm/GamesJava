package Main;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;

public class Main implements Runnable {
	private final Game game;
	private final int Width, Height;

	public Main() {
		Width = 800;
		Height = 600;
		game = new Game();
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.Start();
	}

	private Thread thread;

	private void Start() {
		thread = new Thread(this, "Game");
		thread.start();
		game.setRunning(true);
	}

	private long window;

	private void Init() {
		if (!glfwInit()) {
			// TODO: Handle it;
			return;
		}
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);
		window = glfwCreateWindow(Width, Height, "Flappy Bird", 0, 0);
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, vidmode.width() / 2, vidmode.height() / 2);
		if (window == 0) {
			// TODO: handle
		}
		glfwShowWindow(window);
	}

	public void run() {
		Init();
		while (game.isRunning()) {
			Update();
			Render();
			if (glfwWindowShouldClose(window))
				game.setRunning(false);
		}
	}

	private void Update() {
		glfwPollEvents();
	}

	private void Render() {
		glfwSwapBuffers(window);
	}
}