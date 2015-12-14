package cellocoder.compo;

public class GameManager {
	
	public Game game;
	public Dialogue dialogue;
	
	public int lvl = 1;
	
	public GameState state = GameState.INTRO;
	
	public GameManager() {
		state = GameState.INTRO;
		game = new Game(20 * lvl, 2.5f * lvl);
		dialogue = new Dialogue(new String[] { "Press Z or X to\ncontinue...", "So, some programmer didn't\ncode things right...",
				"Now we've got memory\nleaking everywhere, and\ntextures run rampant.", "You have been sent here by\nLord Gaben to clean things\nup.",
				"He has noticed you have him\nas your desktop...\nHe likes to be a\nScreen-Saviour Screensaver,\ny'know.",
				"Use Z and X to roll around to clean\nup the textures, or else\nthe computer will explode!!!" }, 6);
	}
	
	public void tick() {
		if (state == GameState.GAME) {
			ReturnState rs = game.tick();
			if (rs == ReturnState.SUCCESS) {
				lvl++;
				Sound.play(Sound.SUCCESS);
				game = new Game(20 * lvl, 2.5f * lvl);
			} else if (rs == ReturnState.FAILURE) {
				Sound.play(Sound.EXPLOSION);
				game = new Game(20 * lvl, 2.5f * lvl);
			}
		} else if (state == GameState.INTRO) {
			ReturnState rs = dialogue.tick();
			if (rs == ReturnState.SUCCESS) {
				state = GameState.GAME;
			}
		} else if (state == GameState.END) {
			
		} else {
			
		}
	}
	
	public void render() {
		if (state == GameState.GAME) {
			game.render();
		} else if (state == GameState.INTRO) {
			dialogue.render();
		} else if (state == GameState.END) {
			
		} else {
			
		}
	}
	
}
