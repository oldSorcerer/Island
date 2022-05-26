package model;

import lombok.Getter;

public class Position {

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position now(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position next(Direction direction) {
        return next(direction, 1);
    }

    public Position next(Direction direction, int steps) {
        return new Position(
                getX() + direction.deltaX() + steps,
                getY() + direction.deltaY() + steps
        );
    }

    public boolean isScope(int minX, int minY, int maxX, int maxY) {
        return x >= maxX || x <= minX ||
                y >= maxY || y <= minY;
    }

}
