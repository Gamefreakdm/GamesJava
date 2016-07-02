package Main;

import Input.KeyHandler;
import Input.MouseHandler;

public class Game {
	private String Game_State;
	private final KeyHandler KH;
	private final MouseHandler MH;
	private boolean Running = false;

	public Game(KeyHandler k, MouseHandler m) {
		KH = k;
		MH = m;
		Game_State = "Home";
		MH.UpdateButtons(Game_State);
	}

	public void Update() {
		String pastgs = Game_State;
		MH.CheckIsHovered();
		MH.UpdateButtons();
		if (Game_State != pastgs)
			MH.UpdateButtons(Game_State);
	}

	public void KeyUpdate() {
	}

	public boolean isRunning() {
		return Running;
	}

	public void setRunning(boolean running) {
		Running = running;
	}

	public String getGame_State() {
		return Game_State;
	}

	public void setGame_State(String game_State) {
		Game_State = game_State;
	}
}
