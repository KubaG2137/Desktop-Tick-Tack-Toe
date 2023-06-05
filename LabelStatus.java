package tictactoe;

import javax.swing.*;

public class LabelStatus extends JLabel {
    static JLabel labelStatus = new JLabel();
    public void createLabel() {
        labelStatus.setName("LabelStatus");
        labelStatus.setText("Game is not started");
    }
}
