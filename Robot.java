package tictactoe;

import javax.swing.*;

public class Robot {

    static char[][] charBoard = new char[3][3];
    static void setCharBoard(JButton[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                charBoard[i][j] = board[i][j].getText().charAt(0);
            }
        }
    }

    static void isRobotXorO(){
        if (PlayerButtons.buttonPlayer1.getText().equals("Robot")){
            Minimax.player1 = 'X';
            Minimax.player2 = 'O';
        } else if (PlayerButtons.buttonPlayer2.getText().equals("Robot")){
            Minimax.player1 = 'O';
            Minimax.player2 = 'X';

        }
    }
    public void robot() {
        isRobotXorO();
        setCharBoard(Board.btnArr);
        int[] bestMove = Minimax.findBestMove(charBoard);
        JButton button = Board.btnArr[bestMove[0]][bestMove[1]];

        new Board().symbolChanger(button);
        button.setEnabled(false);
        Board.turnSwitch = !Board.turnSwitch;
        new Board().whoseTurn();
        new Board().gameStatus();
    }
}
