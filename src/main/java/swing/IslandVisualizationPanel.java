package swing;

import model.Island;
import model.Position;
import model.Rabbit;

import javax.swing.*;
import java.awt.*;
//import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class IslandVisualizationPanel extends JPanel {

    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    //
    private Island island;

    public IslandVisualizationPanel() {
        super(true);
    }

    public void initialization() {
        island = Island.create(WIDTH, HEIGHT);
        new Timer(false).scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               // updateGame();
                island.update();
                repaint();
            }
        }, 0, 100);

        IntStream.range(0, 50).forEach(i -> {
            int randX = ThreadLocalRandom.current().nextInt(WIDTH);
            int randY = ThreadLocalRandom.current().nextInt(HEIGHT);
            island.addUnit(new Rabbit(island, Position.now(randX, randY)));
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //paintField((Graphics2D) g);
        island.draw((Graphics2D) g);
    }

    private void paintField(Graphics2D g) {
        island.draw(g);
    }

    public void updateGame() {
        island.update();
        repaint();
    }
}

