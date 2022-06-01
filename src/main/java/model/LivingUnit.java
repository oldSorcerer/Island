package model;

import lombok.Getter;
import lombok.Setter;
import model.animals.predator.Snake;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public abstract class LivingUnit implements DrawableUnit {

    protected final Health<Integer> health = new Health<>(0, 100);
    private final List<Consumer<LivingUnit>> birthList = new CopyOnWriteArrayList<>();
    private final List<Consumer<LivingUnit>> deadList = new CopyOnWriteArrayList<>();
    private final List<Class<? extends LivingUnit>> canEat;

    @Getter
    @Setter
    private Position position;

    abstract void updateHealth();

    public LivingUnit(Position position, List<Class<? extends LivingUnit>> canEat) {
        this.position = position;
        this.canEat = canEat;
    }

    public void updateMain() {
        updateHealth();
        if (health.getCurrent() < health.getMin()) {
            kill();
        }
    }

    public void birth(LivingUnit livingUnit) {
        birthList.forEach(birth -> birth.accept(livingUnit));
    }

    public void kill() {
        deadList.forEach(dead -> dead.accept(this));
        deadList.clear();
    }

    public void addBirthList(Consumer<LivingUnit> livingUnit) {
        birthList.add(livingUnit);
    }

    public void addDeadList(Consumer<LivingUnit> livingUnit) {
        deadList.add(livingUnit);
    }

    public boolean isEatable(Class<? extends LivingUnit> eatable) {
        return canEat.contains(eatable);
    }
}
