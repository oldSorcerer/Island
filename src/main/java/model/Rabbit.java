package model;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends LivingUnit {

    public static final int SIZE = 10;
    public static final Color BORDER = Color.PINK;

    private final Island island;

    public Rabbit(Island island, Position position){
        super(position);
        this.island = island;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(BORDER);
        g.fillRect(0, 0, SIZE - 1, SIZE - 1);
    }

    @Override
    public void update() {
        List<Position> collect = Arrays.stream(Direction.values())
                .map(direction -> getPosition().next(direction))
                .filter(newPos -> !newPos.isScope(0, 0, island.getWidth(), island.getHeight())).toList();

        if (collect.isEmpty()) {
            return;
        }
        Position position = collect.get(ThreadLocalRandom.current().nextInt(collect.size()));
        setPosition(position);
    }
}
