import swing.IslandVisualizationPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private IslandVisualizationPanel mainPanel;

    public MainWindow() throws HeadlessException{
        super("Island");
    }

    public void initialization() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,800);

        mainPanel = new IslandVisualizationPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.initialization();

        setContentPane(mainPanel);
        setVisible(true);
    }
}
