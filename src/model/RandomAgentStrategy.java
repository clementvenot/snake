package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import utils.AgentAction;

public class RandomAgentStrategy implements AgentStrategy {

    @Override
    public AgentAction chooseAction(Snake agent, SnakeGame game) {
        List<AgentAction> legalActions = new ArrayList<>();
        for (AgentAction action : AgentAction.values()) {
            if (game.isLegalMove(agent, action)) {
                legalActions.add(action);
            }
        }

        if (legalActions.isEmpty()) {
            return null;
        }

        return legalActions.get(ThreadLocalRandom.current().nextInt(legalActions.size()));
    }
}
