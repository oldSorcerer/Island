package model;

import lombok.Getter;
import lombok.Setter;

public abstract class LivingUnit implements DrawableUnit {

    @Getter
    @Setter
    private Position position;

    public LivingUnit(Position position) {
        this.position = position;
    }
}
