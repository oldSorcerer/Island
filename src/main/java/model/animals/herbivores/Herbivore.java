package model.animals.herbivores;

import model.animals.Movable;
import model.Position;

public abstract class Herbivore implements Movable {

    Position position;

    public Herbivore(Position position) {
        this.position = position;
    }


}
