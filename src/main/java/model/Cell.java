package model;

import lombok.Getter;

import java.awt.*;

public class Cell implements DrawableUnit {

    public static final int SIZE = 20;
    public static final Color BORDER = Color.LIGHT_GRAY;

    @Getter
    private final Position position;

    public Cell(int x, int y) {
        this.position = Position.now(x, y);
    }

    @Override
    public void update() {
        // nothing changes
    }

    public void draw(Graphics2D g) {
        g.setColor(BORDER);
        g.drawRect(position.getX() * SIZE, position.getY() * SIZE, SIZE - 1, SIZE - 1);
    }
}

