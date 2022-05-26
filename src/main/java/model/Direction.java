package model;

import lombok.Getter;

public enum Direction {

    NO(Position.now(0, 0)),
    UP(Position.now(0, 1)),
    DOWN(Position.now(0, -1)),
    LEFT(Position.now(-1, 0)),
    RIGHT(Position.now(1, 0));

    @Getter
    private final Position shift;

    Direction(Position shift) {
        this.shift = shift;
    }
}
