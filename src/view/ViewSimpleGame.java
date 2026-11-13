package view;

import javax.swing.*;

import model.Game;
import model.GameObserver;

import java.awt.*;

public class ViewSimpleGame implements GameObserver{

    private JFrame frame;
    private JLabel labelTurn;

    public ViewSimpleGame() {

        frame = new JFrame();
        frame.setTitle("Snake");
        frame.setSize(new Dimension(700, 700));

        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2 - 350;

        frame.setLocation(dx, dy);

        labelTurn = new JLabel("Turn : 0", JLabel.CENTER);
        labelTurn.setFont(new Font("Arial", Font.BOLD, 30));

        frame.add(labelTurn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setTurn(int turn) {
        labelTurn.setText("Turn : " + turn);
    }

	@Override
	public void update(Game game) {
	    setTurn(game.getCurrentTurn());		
	}
}
