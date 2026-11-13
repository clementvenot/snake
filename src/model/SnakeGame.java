package model;

import java.util.ArrayList;

import utils.FeaturesItem;
import utils.FeaturesSnake;

public class SnakeGame extends Game{
	
    private InputMap map;

	// liste d'agent
    private ArrayList<Snake> snakes;
    private ArrayList<FeaturesItem> items;


    public SnakeGame(InputMap map, int maxTurn, long time) {
        super(maxTurn, time);
        this.map = map;
    }

	@Override
	protected void initializeGame() {
		snakes = new ArrayList<Snake>();
		for (FeaturesSnake featuresSnake : map.getStart_snakes()) {
			snakes.add(createSnake(featuresSnake));
		}

		items = new ArrayList<FeaturesItem>(map.getStart_items());
	}

	protected Snake createSnake(FeaturesSnake featuresSnake) {
		return new Snake(featuresSnake);
	}

	@Override
	protected void takeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void gameOver() {
		// TODO Auto-generated method stub
		
	}

}
