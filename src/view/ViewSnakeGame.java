package view;

import java.awt.Dimension;
import javax.swing.JFrame;

import model.Game;
import model.GameObserver;
import model.Snake;
import model.SnakeGame;
import utils.FeaturesItem;
import utils.FeaturesSnake;
import utils.Position;

import java.util.ArrayList;

public class ViewSnakeGame implements GameObserver {

    private JFrame frame;
    private final PanelSnakeGame panel;

    public ViewSnakeGame(PanelSnakeGame panel) {
        this.panel = panel;

        frame = new JFrame("Snake");

        frame.setSize(new Dimension(1200,800));

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    @Override
    public void update(Game game) {
        if (!(game instanceof SnakeGame)) {
            return;
        }

        SnakeGame snakeGame = (SnakeGame) game;
        ArrayList<FeaturesSnake> featuresSnakes = new ArrayList<>();
        for (Snake snake : snakeGame.getSnakes()) {
            ArrayList<Position> positions = new ArrayList<>();
            for (Position position : snake.getPositions()) {
                positions.add(new Position(position.getX(), position.getY()));
            }
            featuresSnakes.add(new FeaturesSnake(
                    positions,
                    snake.getLastAction(),
                    snake.getColorSnake(),
                    snake.isInvincible(),
                    snake.isSick()));
        }

        ArrayList<FeaturesItem> featuresItems =
                new ArrayList<>(snakeGame.getItems());
        panel.updateInfoGame(featuresSnakes, featuresItems);
    }
}