import javax.swing.JFrame;

public class Main {
	private boolean Running = false;
	private final JFrame MFrame = new JFrame("Loading...");
	private final int Width = 800, Height = 600;

	public static void main(String args[]) {
		Main m = new Main();
		m.MFrame.setResizable(false);
		m.MFrame.setSize(m.Width, m.Height);
		m.MFrame.setLocationRelativeTo(null);
		m.MFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.MFrame.setTitle("Transformation");
		m.MFrame.setVisible(true);
		m.Start();
	}

	private void Start() {
		if (!Running) {
			Running = true;
			Run();
		}
		Stop();
	}

	private void Stop() {
		if (!Running)
			System.exit(0);
		return;
	}

	private void Run() {
		long Timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double Delta = 0;
		final double NS = 1000000000.0 / 120;
		System.out.println("[System] Started");
		while (Running) {
			long nowTime = System.nanoTime();
			Delta += (nowTime - lastTime) / NS;
			lastTime = nowTime;
			while (Delta >= 1) {
				Update();
				Delta--;
			}
			Render();
			if (System.currentTimeMillis() - Timer >= 1000) {
				Timer += 1000;
			}
		}
		Stop();
	}

	private void Update() {
	}

	private void Render() {
	}
}