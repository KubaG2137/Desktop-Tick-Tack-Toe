package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    static boolean currentPlayerSwitch = true;

    static boolean turnSwitch = true;

    static JPanel gameBoard = new JPanel();

    static JButton[][] btnArr = new JButton[3][3];

    static String currentPlayer;


    public void symbolChanger(JButton button) {
        if (button.getText().equals(" ")) {
            if (currentPlayerSwitch) {
                currentPlayer = "X";
                button.setText(currentPlayer);
                currentPlayerSwitch = false;
            } else {
                currentPlayer = "O";
                button.setText(currentPlayer);
                currentPlayerSwitch = true;
            }
        }
    }

    public void gameStatus() {
        if (hasPlayerWon(currentPlayer)) {
            if(currentPlayer.equals("X")){
                LabelStatus.labelStatus.setText("The " + PlayerButtons.buttonPlayer1.getText()
                        + " Player " + "(" + currentPlayer + ") wins");
            } else {
                LabelStatus.labelStatus.setText("The " + PlayerButtons.buttonPlayer2.getText()
                        + " Player " + "(" + currentPlayer + ") wins");
            }
            for (JButton[] innerArr : btnArr) {
                for (JButton btn : innerArr) {
                    btn.setEnabled(false);
                }
            }
        } else if (draw()) {
            LabelStatus.labelStatus.setText("Draw");
            for (JButton[] innerArr : btnArr) {
                for (JButton btn : innerArr) {
                    btn.setEnabled(false);
                }
            }
        }
    }

    public void createButtons() {
        for (int i = 0; i < 3; i++) {
            char letter = 'A';
            for (int j = 0; j < 3; j++) {
                var button = new JButton();
                String buttonName = "" + letter + (3 - i);
                button.setName("Button" + buttonName);
                button.setText(" ");
                button.setBackground(Color.YELLOW);
                button.setFont(new Font("Arial", Font.BOLD, 40));
                button.addActionListener(e -> {
                    symbolChanger(button);
                    turnSwitch = !turnSwitch;
                    whoseTurn();
                    gameStatus();
                    if(!hasPlayerWon(currentPlayer) &&
                            PlayerButtons.buttonPlayer1.getText().equals("Robot") ||
                            PlayerButtons.buttonPlayer2.getText().equals("Robot")){
                        new Robot().robot();
                    }
                    button.setEnabled(false);
                });
                btnArr[i][j] = button;
                letter++;
            }
        }
    }

    public void whoseTurn() {
        if (turnSwitch) {
            LabelStatus.labelStatus.setText("The turn of " + PlayerButtons.buttonPlayer1.getText()
                    + " Player (X)");
        } else {
            LabelStatus.labelStatus.setText("The turn of " + PlayerButtons.buttonPlayer2.getText()
                    + " Player (O)");
        }
    }
    public void createBoard() {
        gameBoard.setLayout(new GridLayout(3, 3, 10, 10));
        createButtons();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard.add(btnArr[i][j]);
            }
        }
    }

    public boolean draw() {
        int c = 0;
        for (JButton[] innerArr : btnArr) {
            for (JButton btn : innerArr) {
                if (btn.getText().equals(" ")) {
                    c++;
                }
            }
        }
        return (c == 0);
    }

    public boolean hasPlayerWon(String player) {
        for (int i = 0; i < 3; i++) {
            if (btnArr[i][0].getText().equals(player) &&
                    btnArr[i][1].getText().equals(player) &&
                    btnArr[i][2].getText().equals(player)) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (btnArr[0][j].getText().equals(player) &&
                    btnArr[1][j].getText().equals(player) &&
                    btnArr[2][j].getText().equals(player)) {
                return true;
            }
        }
        if (btnArr[0][0].getText().equals(player) &&
                btnArr[1][1].getText().equals(player) &&
                btnArr[2][2].getText().equals(player)) {
            return true;
        }
        return btnArr[0][2].getText().equals(player) &&
                btnArr[1][1].getText().equals(player) &&
                btnArr[2][0].getText().equals(player);
    }
}
