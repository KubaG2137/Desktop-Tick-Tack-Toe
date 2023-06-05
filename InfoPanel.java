package tictactoe;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    static JPanel infoPanel = new JPanel();

    public void createInfoPanel() {
        infoPanel.setLayout(new BorderLayout());
        new LabelStatus().createLabel();
        infoPanel.add(LabelStatus.labelStatus, BorderLayout.LINE_START);
    }
}
