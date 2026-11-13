package view;

import javax.swing.*;

import controller.AbstractController;
import model.Game;
import model.GameObserver;

import java.awt.*;

public class ViewCommand implements GameObserver{

    private JFrame frame;

    private JButton restartButton;
    private JButton launchButton;
    private JButton stepButton;
    private JButton pauseButton;

    private JSlider sliderSpeed;

    private JLabel labelTurn;
    
    private AbstractController controller;
    
    public ViewCommand() {

        frame = new JFrame("Commande");
        frame.setSize(384, 200);

        Dimension windowSize = frame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y + 150;

        frame.setLocation(dx, dy);

        JPanel mainPanel = new JPanel(new GridLayout(2,1));

        JPanel panelButtons = new JPanel(new GridLayout(1,4));

        restartButton = new JButton(
                new ImageIcon("icons/icon_restart.png"));

        launchButton = new JButton(
                new ImageIcon("icons/icon_play.png"));

        stepButton = new JButton(
                new ImageIcon("icons/icon_step.png"));

        pauseButton = new JButton(
                new ImageIcon("icons/icon_pause.png"));

        panelButtons.add(restartButton);
        panelButtons.add(launchButton);
        panelButtons.add(stepButton);
        panelButtons.add(pauseButton);

        JPanel panelBottom = new JPanel(new GridLayout(1,2));

        JPanel panelSlider = new JPanel(new BorderLayout());

        JLabel speedLabel =
                new JLabel("Number of turns per second",
                        JLabel.CENTER);

        sliderSpeed = new JSlider(1, 10, 1);

        sliderSpeed.setMajorTickSpacing(1);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(true);
        sliderSpeed.setSnapToTicks(true);

        panelSlider.add(speedLabel, BorderLayout.NORTH);
        panelSlider.add(sliderSpeed, BorderLayout.CENTER);

        labelTurn = new JLabel("Turn : 0", JLabel.CENTER);
        labelTurn.setFont(new Font("Arial", Font.BOLD, 18));

        panelBottom.add(panelSlider);
        panelBottom.add(labelTurn);

        mainPanel.add(panelButtons);
        mainPanel.add(panelBottom);

        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getLaunchButton() {
        return launchButton;
    }

    public JButton getStepButton() {
        return stepButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JSlider getSliderSpeed() {
        return sliderSpeed;
    }

    public void setTurn(int turn) {
        labelTurn.setText("Turn : " + turn);
    }
    
    public void setController(AbstractController controller) {
        this.controller = controller;
        addButtonListener();
    }
    
    private void addButtonListener() {

        restartButton.addActionListener(e ->
                controller.restart());

        launchButton.addActionListener(e ->
                controller.play());

        pauseButton.addActionListener(e ->
                controller.pause());

        stepButton.addActionListener(e ->
                controller.step());

        sliderSpeed.addChangeListener(e ->
                controller.setSpeed(
                        sliderSpeed.getValue()));
    }
    
    public void setInitialState() {
        launchButton.setEnabled(true);
        stepButton.setEnabled(true);
        pauseButton.setEnabled(false);
        restartButton.setEnabled(false);
    }

    public void setPlayingState() {
        launchButton.setEnabled(false);
        stepButton.setEnabled(false);
        pauseButton.setEnabled(true);
        restartButton.setEnabled(true);
    }

    public void setPausedState() {
        launchButton.setEnabled(true);
        stepButton.setEnabled(true);
        pauseButton.setEnabled(false);
        restartButton.setEnabled(true);
    }

	@Override
	public void update(Game game) {
	    setTurn(game.getCurrentTurn());		
	}


}