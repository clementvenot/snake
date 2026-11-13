package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements Runnable {

    protected int currentTurn;
    protected final int maxTurn;
    protected boolean isRunning;
    protected Thread thread;
    protected long time;
    private List<GameObserver> observers = new ArrayList<>();
    
    

    public Game(int maxTurn, long time) {
        this.maxTurn = maxTurn;
        this.time = time;
        this.currentTurn = 0;;
        this.isRunning = false;
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
    
    public void setTime(long time) {
        this.time = time;
    }

    public void init() {
        currentTurn = 0;
        isRunning = true;
        initializeGame();
        notifyObservers();
    }

    public void launch() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void step() {
        if (!isGameOver() && currentTurn < maxTurn) {
            currentTurn++;
            takeTurn();
            notifyObservers();
        } else {
            isRunning = false;
            gameOver();
            notifyObservers();
        }
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            step();

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for(GameObserver obs : observers) {
            obs.update(this);
        }
    }

    protected abstract void initializeGame();
    protected abstract void takeTurn();
    protected abstract boolean isGameOver();
    protected abstract void gameOver();
}