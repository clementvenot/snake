package controller;

import model.InputMap;
import model.SnakeGame;
import view.PanelSnakeGame;
import view.ViewSnakeGame;

public class ControllerSnakeGame extends AbstractController {

    private ViewSnakeGame viewGame;

    public ControllerSnakeGame() {

        super(
            new SnakeGame(
                new InputMap("layouts/arena.lay"),
                10000,
                500
            )
        );

        SnakeGame snakeGame = (SnakeGame) game;

        InputMap map = new InputMap("layouts/arena.lay");

        PanelSnakeGame panel =
                new PanelSnakeGame(
                        map.getSizeX(),
                        map.getSizeY(),
                        map.get_walls(),
                        map.getStart_snakes(),
                        map.getStart_items());

        viewGame = new ViewSnakeGame(panel);
    }
}
