package model.herbivores;

public abstract class Herbivore implements Movable {

    Position position;

    public Herbivore(Position position) {
        this.position = position;
    }


}
