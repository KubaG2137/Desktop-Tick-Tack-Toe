package tictactoe;

public class Minimax {
    static char player1 = 'X', player2 = 'O';

    static Boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    static int evaluate(char[][] b) {
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2]) {
                if (b[row][0] == player1) {
                    return +10;
                } else if (b[row][0] == player2)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col]) {
                if (b[0][col] == player1) {
                    return +10;
                } else if (b[0][col] == player2)
                    return -10;
            }
        }

        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == player1) {
                return +10;
            } else if (b[0][0] == player2)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == player1) {
                return +10;
            } else if (b[0][2] == player2)
                return -10;
        }
        return 0;
    }

    static int minimax(char[][] board,
                       int depth, Boolean isMax) {
        int score = evaluate(board);

        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (!isMovesLeft(board)) {
            return 0;
        }
        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j]==' ') {
                        board[i][j] = player1;
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        }

        else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = player2;
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));
                        board[i][j] = ' ';
                    }
                }
            }
            return best;
        }
    }
    static int[] findBestMove(char[][] board)
    {
        int bestVal = -1000;
        int[] bestMove = new int[]{-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player1;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = ' ';
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
}
