package controller;

import model.Game;
import model.GameState;
import model.PausedState;
import model.PlayingState;
import view.ViewCommand;

public abstract class AbstractController {

	protected Game game;
	private GameState state;
	protected ViewCommand viewCommand;

	public AbstractController(Game game) {
	    this.game = game;
	}
	
	public void setState(GameState state) {
	    this.state = state;
	    state.updateButtons(viewCommand);
	}

    public void restart() {
        game.init();
        game.pause();
        setState(new PausedState());
        
    }

    public void step() {
        game.step();
    }

    public void play() {
        game.launch();
        setState(new PlayingState());
    }

    public void pause() {
        game.pause();
        setState(new PausedState());
    }

    public void setSpeed(double speed) {

        game.setTime((long)(1000 / speed));
    }
}
