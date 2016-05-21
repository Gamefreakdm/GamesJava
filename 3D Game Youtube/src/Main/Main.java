package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import Graphics.Screen;
import Input.InputHandler;

public class Main extends Canvas implements Runnable {
	private int[] Pixels;
	private final Game game;
	private final String Title;
	private final JFrame Frame;
	private BufferedImage bimg;
	public static Screen screen;
	private final InputHandler IH;
	private boolean Ticked = false;
	private final int Width, Height;
	private static final long serialVersionUID = 1L;

	private Main() {
		System.out.println("[System] Starting...");
		Width = 800;
		Height = 600;
		Title = "Pre-Alpha 1.0.1";
		IH = new InputHandler();
		Frame = new JFrame("Loading...");
		game = new Game();
	}

	public static void main(String[] args) {
		Main M = new Main();
		M.Frame.add(M);
		M.Frame.addKeyListener(M.IH);
		M.addMouseListener(M.IH);
		M.addMouseMotionListener(M.IH);
		M.addMouseWheelListener(M.IH);
		M.Frame.addFocusListener(M.IH);
		M.Frame.setSize(M.Width, M.Height);
		M.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		M.Frame.setResizable(false);
		M.Frame.setLocationRelativeTo(null);
		M.Frame.setUndecorated(false);
		M.Frame.setVisible(true);
		M.Start();
	}

	private void Start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	// To tell you the truth when ngwati told me you where leaving I crtied and
	// irais told me not to cry anymore
	// after reading your journal entry yesterday i kinda found peace in it and
	// why your leaving and how it will be for you
	// anyways i want your phone number and adress on that white piece of paper
	// -.- you suck btw -.- who will i talk to now and
	// share everything i want to say and talk about life and how everythings
	// going. who am i gonna go on adventures with
	// like the museum adventure and everything. you just had one year left i
	// had one year more with my best friend and all of that
	// just got cut down to the last day since im going to have am careers and
	// leave from ccd home we wont even be able to see
	// each other dammit dylan why you leaving -.- now two more weeks with no
	// one to talk about but your happy and your figuring
	// your life out so i hope you do well and good luck to you maybe youll make
	// alot of money from making games oh well i cant
	// stop you so i have to accept your leaving but your happy so i guess i
	// should be too i cant say this in person and it's easier
	// to type it and for you to just read it. This sucks balls losing one of my
	// best friends #BABE3 well i love you man you
	// where a really cool guy to be around to talk to and to be with and it was
	// and awesome decision for me to befriend you
	// public void main(String args[]) {
	// System.out.println("love you man");
	// }

	public void run() {
		int Frames = 0;
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		long nowTime = 0;
		final double NS = 1000000000.0 / 60;
		System.out.println("[System] Started");
		while (game.IsRunning()) {
			nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Update();
				Ticked = true;
				Delta--;
			}
			if (Ticked) {
				Render();
				Frames++;
				Ticked = false;
			}
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
				Frame.setTitle(Title + "   |   " + Frames + " Fps");
				Frames = 0;
			}
		}
		Stop();
	}

	private void Update() {
		Frame.requestFocus();
		game.KeyUpdate(IH.Key);
		game.Update();
	}

	private void Render() {
		BufferStrategy BS = getBufferStrategy();
		if (BS == null) {
			bimg = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
			screen = new Screen(Width, Height, game);
			Pixels = ((DataBufferInt) bimg.getRaster().getDataBuffer()).getData();
			createBufferStrategy(3);
			return;
		}
		screen.Render(game.getTime());
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = screen.getPixels()[i];
		}
		Graphics g = BS.getDrawGraphics();
		g.drawImage(bimg, 0, 0, Width, Height, null);
		BS.show();
	}

	private void Stop() {
		System.out.println("[System] Stopping...");
		CleanUp();
		System.exit(0);
	}

	private void CleanUp() {
		screen.clearPixels();
		for (int i = 0; i < Pixels.length; i++) {
			Pixels[i] = 0;
		}
		Frame.dispose();
	}
}