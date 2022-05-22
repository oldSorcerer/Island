package model;

import lombok.Getter;

public class Position {
    @Getter
    private final int x;
    @Getter
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position now(int x, int y) {
        return new Position(x, y);
    }
    public Position next(Direction direction, int steps) {
        return new Position(
                getX() + direction.getShift().getX() + steps,
                getY() + direction.getShift().getY() + steps
        );
    }

    public boolean isScope(int minX, int minY, int maxX, int maxY) {
        return getX() >= maxX || getX() <= minX ||
                getY() >= maxY || getY() <= minY;
    }

}
