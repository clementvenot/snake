package test;

import model.SimpleGame;

public class Test {

    public static void main(String[] args) {

        SimpleGame game = new SimpleGame(5, 1000);

        game.init();
        game.launch();
        
        
    }
}