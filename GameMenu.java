package tictactoe;

import javax.swing.*;

public class GameMenu extends JFrame {
    static JMenu menuGame = new JMenu("Game");

    public void createGameMenu() {

        JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        JMenuItem menuExit = new JMenuItem("Exit");


        menuHumanHuman.setName("MenuHumanHuman");
        menuHumanRobot.setName("MenuHumanRobot");
        menuRobotHuman.setName("MenuRobotHuman");
        menuRobotRobot.setName("MenuRobotRobot");
        menuExit.setName("MenuExit");
        menuGame.setName("MenuGame");

        menuGame.add(menuHumanHuman);
        menuGame.add(menuHumanRobot);
        menuGame.add(menuRobotHuman);
        menuGame.add(menuRobotRobot);

        menuGame.addSeparator();
        menuGame.add(menuExit);

        menuHumanHuman.addActionListener(e -> {
            PlayerButtons.buttonPlayer1.setText("Human");
            PlayerButtons.buttonPlayer2.setText("Human");
            ButtonStartReset.buttonStartReset.setText("Reset");
            new ButtonStartReset().reset();
        });

        menuHumanRobot.addActionListener(e -> {
            PlayerButtons.buttonPlayer1.setText("Human");
            PlayerButtons.buttonPlayer2.setText("Robot");
            ButtonStartReset.buttonStartReset.setText("Reset");
            new ButtonStartReset().reset();
        });

        menuRobotHuman.addActionListener(e -> {
            PlayerButtons.buttonPlayer1.setText("Robot");
            PlayerButtons.buttonPlayer2.setText("Human");
            ButtonStartReset.buttonStartReset.setText("Reset");
            new ButtonStartReset().reset();
        });

        menuRobotRobot.addActionListener(e -> {
            PlayerButtons.buttonPlayer1.setText("Robot");
            PlayerButtons.buttonPlayer2.setText("Robot");
            ButtonStartReset.buttonStartReset.setText("Reset");
            new ButtonStartReset().reset();
        });

        menuExit.addActionListener(e -> System.exit(0));
    }
}
