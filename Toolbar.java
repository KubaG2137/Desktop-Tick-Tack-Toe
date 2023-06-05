package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    static JPanel toolbar = new JPanel();

    public void createToolbar() {
        toolbar.setLayout(new FlowLayout(FlowLayout.TRAILING, 75,5));
        new ButtonStartReset().createButtonStartReset();
        new PlayerButtons().createPlayerButtons();
        toolbar.add(PlayerButtons.buttonPlayer1);
        toolbar.add(ButtonStartReset.buttonStartReset);
        toolbar.add(PlayerButtons.buttonPlayer2);
    }
}
