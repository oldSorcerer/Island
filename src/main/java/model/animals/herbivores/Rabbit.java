package model.animals.herbivores;

import model.Island;
import model.Position;


public class Rabbit extends Herbivore {

    Island island;

    public Rabbit(Island island, Position position){
        super(position);
        this.island = island;
    }

    @Override
    public void move() {

    }
}
