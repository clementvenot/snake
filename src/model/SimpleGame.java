package model;

public class SimpleGame extends Game {

    public SimpleGame(int maxTurn, long time) {
        super(maxTurn, time);
    }

    @Override
    protected void initializeGame() {
        System.out.println("Initialisation du jeu");
    }

    @Override
    protected void takeTurn() {
        System.out.println("Tour " + currentTurn);
    }

    @Override
    protected boolean isGameOver() {
        return false;
    }

    @Override
    protected void gameOver() {
        System.out.println("Fin du jeu");
    }
}