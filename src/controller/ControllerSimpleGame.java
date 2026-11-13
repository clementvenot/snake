package controller;

import model.InitialState;
import model.SimpleGame;
import view.ViewCommand;
import view.ViewSimpleGame;

public class ControllerSimpleGame extends AbstractController {

    private ViewSimpleGame viewGame;

    public ControllerSimpleGame() {

        super(new SimpleGame(1000,1000));


        viewGame = new ViewSimpleGame();
        viewCommand = new ViewCommand();
        

        setState(new InitialState());
        
        

        game.addObserver(viewGame);
        game.addObserver(viewCommand);

        viewCommand.setController(this);

        game.init();
    }
}
