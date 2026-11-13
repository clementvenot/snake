package model;

import java.util.ArrayList;
import utils.AgentAction;
import utils.ColorSnake;
import utils.FeaturesSnake;
import utils.Position;

public class Snake {
	
	private ArrayList<Position> positions;
	private AgentAction lastAction;
	private ColorSnake colorSnake;
	private boolean isInvincible;
	private boolean isSick;
	
	public Snake (FeaturesSnake feature) {
		
		this.positions = new ArrayList<Position>();
		for (Position position : feature.getPositions()) {
			this.positions.add(new Position(position.getX(), position.getY()));
		}
		
		this.lastAction = feature.getLastAction();
		this.colorSnake = feature.getColorSnake();
		this.isInvincible = feature.isInvincible();
		this.isSick = feature.isSick();
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}
	public void setPositions(ArrayList<Position> positions) {
		this.positions = positions;
	}
	public AgentAction getLastAction() {
		return lastAction;
	}
	public void setLastAction(AgentAction lastAction) {
		this.lastAction = lastAction;
	}
	public ColorSnake getColorSnake() {
		return colorSnake;
	}
	public void setColorSnake(ColorSnake colorSnake) {
		this.colorSnake = colorSnake;
	}
	public boolean isInvincible() {
		return isInvincible;
	}
	public void setInvincible(boolean isInvincible) {
		this.isInvincible = isInvincible;
	}
	public boolean isSick() {
		return isSick;
	}
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}

	public void move() {
		if (positions.isEmpty()) { // si le serpent est vide
			return;
		}

		for (int i = positions.size() - 1; i > 0; i--) {
			Position previous = positions.get(i - 1);
			positions.get(i).setX(previous.getX());
			positions.get(i).setY(previous.getY());
		}

		Position head = positions.get(0);

		switch (lastAction) {
		case MOVE_UP:
			head.setY(head.getY() - 1);
			break;
		case MOVE_DOWN:
			head.setY(head.getY()+ 1);
			break;
		case MOVE_LEFT:
			head.setX(head.getX() - 1);
			break;
		case MOVE_RIGHT:
			head.setX(head.getX() + 1);
			break;
		default:
			break;
		}
	}

	public void grow() {
		if (positions.isEmpty()) {
			return;
		}

		Position tail = positions.get(positions.size() - 1);
		positions.add(new Position(tail.getX(), tail.getY()));
	}

}