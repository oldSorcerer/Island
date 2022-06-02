package model;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends LivingUnit {

    public static final int SIZE = 10;
    public static final int FOOD_VALUE = 20; // вес животного дороботать позднее
    public static final Color BORDER = Color.PINK;

    private final Island island;

    public Rabbit(Island island, Position position){
        super(position, Collections.emptyList());
        this.island = island;
    }

    @Override
    public void draw(Graphics2D g) {
        int xIndent = (int) ((g.getClipBounds().getWidth() - SIZE) / 1.5);
        int yIndent = (int) ((g.getClipBounds().getHeight() - SIZE) / 1.5);
        g.setColor(BORDER);
        g.fillRect(xIndent, yIndent, SIZE - 1, SIZE - 1);
    }

    @Override
    public void update() {
        List<Position> availableDir = Arrays.stream(Direction.values())
                .map(direction -> getPosition().next(direction))
                .filter(newPos -> !newPos.isScope(0, 0, island.getWidth(), island.getHeight())).toList();

        if (availableDir.isEmpty()) {
            return;
        }
        Position newPosition = availableDir.get(ThreadLocalRandom.current().nextInt(availableDir.size()));
        setPosition(newPosition);
    }

    @Override
    void updateHealth() {
        //to do
    }
}
