package model;

import view.ViewCommand;

public class PlayingState implements GameState{
	
    @Override
    public void updateButtons(ViewCommand view) {

        view.getLaunchButton().setEnabled(false);
        view.getStepButton().setEnabled(false);
        view.getPauseButton().setEnabled(true);
        view.getRestartButton().setEnabled(true);
    }

}
