package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        new Board().createBoard();
        new InfoPanel().createInfoPanel();
        new Toolbar().createToolbar();
        new GameMenu().createGameMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(GameMenu.menuGame);

        JPanel masterPanel = new JPanel(new BorderLayout());
        masterPanel.add(Toolbar.toolbar,BorderLayout.PAGE_START);
        masterPanel.add(Board.gameBoard, BorderLayout.CENTER);
        masterPanel.add(InfoPanel.infoPanel, BorderLayout.PAGE_END);
        this.getContentPane().add(masterPanel);

        setVisible(true);

    }
}
