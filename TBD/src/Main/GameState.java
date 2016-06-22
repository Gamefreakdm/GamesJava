package Main;

public class GameState {
	private String Game_State;

	public GameState(String gs) {
		setGame_State(gs);
	}

	public void Update() {
	}

	public String getGame_State() {
		return Game_State;
	}

	public void setGame_State(String game_State) {
		Game_State = game_State;
	}
}