package model;

import utils.AgentAction;

public interface AgentStrategy {

    AgentAction chooseAction(Snake agent, SnakeGame game);
}
