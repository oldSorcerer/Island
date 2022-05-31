import swing.IslandVisualizationPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    //private IslandVisualizationPanel mainPanel;

    public MainWindow() {
        super("Island");
    }

    public void initialization() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);

        IslandVisualizationPanel mainPanel = new IslandVisualizationPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.initialization();

        setContentPane(mainPanel);
        setVisible(true);

        //setResizable(false);
        setLocationRelativeTo(null);
    }
}

