package view;

import java.awt.Dimension;
import javax.swing.JFrame;

public class ViewSnakeGame {

    private JFrame frame;

    public ViewSnakeGame(PanelSnakeGame panel) {

        frame = new JFrame("Snake");

        frame.setSize(new Dimension(1200,800));

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}