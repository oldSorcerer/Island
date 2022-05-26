package model;

public enum Direction {

    NO(Position.now(0, 0)),
    UP(Position.now(0, -1)),
    DOWN(Position.now(0, 1)),
    LEFT(Position.now(-1, 0)),
    RIGHT(Position.now(1, 0));

    private final Position delta;

    Direction(Position shift) {
        this.delta = shift;
    }

    public int deltaX() {
        return delta.getX();
    }

    public int deltaY() {
        return delta.getY();
    }
}
