package model;

import view.ViewCommand;

public class InitialState implements GameState{
	
    @Override
    public void updateButtons(ViewCommand view) {

        view.getLaunchButton().setEnabled(true);
        view.getStepButton().setEnabled(true);
        view.getPauseButton().setEnabled(false);
        view.getRestartButton().setEnabled(false);
    }

}
