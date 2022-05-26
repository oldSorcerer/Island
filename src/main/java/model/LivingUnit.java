package model;

public abstract class LivingUnit implements DrawableUnit {

    private Position position;

    public LivingUnit(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }
}
