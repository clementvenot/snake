package model;

import java.util.ArrayList;

import utils.AgentAction;
import utils.FeaturesItem;
import utils.FeaturesSnake;
import utils.Position;

public class SnakeGame extends Game{
	
    private InputMap map;
    private final AgentStrategy agentStrategy;

	// liste d'agent
    private ArrayList<Snake> snakes;
    private ArrayList<FeaturesItem> items;


    public SnakeGame(InputMap map, int maxTurn, long time) {
        this(map, maxTurn, time, new RandomAgentStrategy());
    }

    public SnakeGame(InputMap map, int maxTurn, long time, AgentStrategy agentStrategy) {
        super(maxTurn, time);
        this.map = map;
        if (agentStrategy == null) {
            throw new IllegalArgumentException("agentStrategy must not be null");
        }
        this.agentStrategy = agentStrategy;
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
	    for (Snake snake : snakes) {
	        AgentAction action = agentStrategy.chooseAction(snake, this);
	        if (action != null) {
	            moveAgent(snake, action);
	        }
	    }
	}

	public boolean isLegalMove(Snake agent, AgentAction action) {
	    if (agent == null || action == null || agent.getPositions().isEmpty()) {
	        return false;
	    }

	    Position head = agent.getPositions().get(0);
	    int nextX = wrap(head.getX() + deltaX(action), map.getSizeX());
	    int nextY = wrap(head.getY() + deltaY(action), map.getSizeY());
	    return !map.get_walls()[nextX][nextY];
	}

	public void moveAgent(Snake agent, AgentAction action) {
	    if (!isLegalMove(agent, action)) {
	        return;
	    }

	    ArrayList<Position> positions = agent.getPositions();
	    for (int i = positions.size() - 1; i > 0; i--) {
	        positions.get(i).setX(positions.get(i - 1).getX());
	        positions.get(i).setY(positions.get(i - 1).getY());
	    }

	    Position head = positions.get(0);
	    head.setX(wrap(head.getX() + deltaX(action), map.getSizeX()));
	    head.setY(wrap(head.getY() + deltaY(action), map.getSizeY()));
	    agent.setLastAction(action);
	}

	private int deltaX(AgentAction action) {
	    switch (action) {
	    case MOVE_LEFT:
	        return -1;
	    case MOVE_RIGHT:
	        return 1;
	    default:
	        return 0;
	    }
	}

	private int deltaY(AgentAction action) {
	    switch (action) {
	    case MOVE_UP:
	        return -1;
	    case MOVE_DOWN:
	        return 1;
	    default:
	        return 0;
	    }
	}

	private int wrap(int coordinate, int size) {
	    return (coordinate + size) % size;
	}

	public ArrayList<Snake> getSnakes() {
	    return snakes;
	}

	public ArrayList<FeaturesItem> getItems() {
	    return items;
	}

	@Override
	protected boolean isGameOver() {
		return false;
	}

	@Override
	protected void gameOver() {
	}

}
