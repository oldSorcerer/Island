package model.animals.herbivores;

import model.Position;

public abstract class Herbivore {

    private Position position;

    public Herbivore(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
