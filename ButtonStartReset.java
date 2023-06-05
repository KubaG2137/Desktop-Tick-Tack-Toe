package tictactoe;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ButtonStartReset extends JButton implements ActionListener {
    static JButton buttonStartReset = new JButton();

    static boolean buttonStartResetSwitch = false;

    public void resetGame() {
        for (JButton[] innerArr : Board.btnArr) {
            for (JButton btn : innerArr) {
                btn.setText(" ");
                Board.currentPlayerSwitch = true;
                Board.turnSwitch = true;
            }
        }
        LabelStatus.labelStatus.setText("Game is not started");
        PlayerButtons.buttonPlayer1.setEnabled(true);
        PlayerButtons.buttonPlayer2.setEnabled(true);
    }
    public void createButtonStartReset() {
        buttonStartReset.addActionListener(this);
        buttonStartReset.setText("Start");
        buttonStartReset.setName("ButtonStartReset");
        for (JButton[] innerArr : Board.btnArr) {
            for (JButton btn : innerArr) {
                btn.setEnabled(false);
            }
        }
    }
    public void startResetCheck() {
        if(buttonStartResetSwitch) {
            buttonStartReset.setText("Start");
        } else {
            buttonStartReset.setText("Reset");
        }
    }

    public void start(){
        if (buttonStartReset.getText().equals("Start")){
            for (JButton[] innerArr : Board.btnArr) {
                for (JButton btn : innerArr) {
                    btn.setEnabled(false);
                }
            }
            resetGame();
        }
    }

    public void reset(){
        if (buttonStartReset.getText().equals("Reset")) {
            LabelStatus.labelStatus.setText("The turn of " + PlayerButtons.buttonPlayer1.getText()
                    + " Player (X)");
            for (JButton[] innerArr : Board.btnArr) {
                for (JButton btn : innerArr) {
                    btn.setEnabled(true);
                    btn.setText(" ");
                    Board.currentPlayerSwitch = true;
                    Board.turnSwitch = true;
                }
            }
            PlayerButtons.buttonPlayer1.setEnabled(false);
            PlayerButtons.buttonPlayer2.setEnabled(false);
            if (PlayerButtons.buttonPlayer1.getText().equals("Robot") &&
                    PlayerButtons.buttonPlayer2.getText().equals("Human")) {
                new Robot().robot();
            }
            if (PlayerButtons.buttonPlayer1.getText().equals("Robot") &&
                    PlayerButtons.buttonPlayer2.getText().equals("Robot")) {
                while(!new Board().hasPlayerWon(Board.currentPlayer)) {
                    new Board().gameStatus();
                    new Robot().robot();
                }
                new Board().gameStatus();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startResetCheck();
        start();
        reset();
        buttonStartResetSwitch = !buttonStartResetSwitch;
    }
}
