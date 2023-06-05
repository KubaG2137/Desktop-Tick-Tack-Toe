package tictactoe;

import javax.swing.*;

public class PlayerButtons extends JButton {

    static JButton buttonPlayer1 = new JButton();

    static JButton buttonPlayer2 = new JButton();

    static boolean player1ButtonSwitch = false;
    static boolean player2ButtonSwitch = false;


    public void createPlayerButtons() {
        buttonPlayer1.setText("Human");
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer2.setText("Human");
        buttonPlayer2.setName("ButtonPlayer2");
        buttonPlayer1.addActionListener(e -> {
            if(player1ButtonSwitch) {
                buttonPlayer1.setText("Human");
            } else {
                buttonPlayer1.setText("Robot");
            }
            player1ButtonSwitch = !player1ButtonSwitch;
        });
        buttonPlayer2.addActionListener(e -> {
            if(player2ButtonSwitch) {
                buttonPlayer2.setText("Human");
            } else {
                buttonPlayer2.setText("Robot");
            }
            player2ButtonSwitch = !player2ButtonSwitch;
        });
    }
}
