package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends LivingUnit {

    private static final Logger LOGGER = LoggerFactory.getLogger(Wolf.class);

    private static final double BIRTH_RATE = 0.3;
    public static final int SIZE = 15;
    public static final Color BORDER = Color.ORANGE;

    private final Island island;
    private final Sex sex;

    public Wolf(Island island, Position position, Sex sex) {
        super(position, Collections.singletonList(Rabbit.class));
        this.island = island;
        this.sex = sex;
    }

    @Override
    public void draw(Graphics2D g) {
        int xIndent = (int) ((g.getClipBounds().getWidth() - SIZE) / 1.5);
        int yIndent = (int) ((g.getClipBounds().getHeight() - SIZE) / 1.5);
        g.setColor(BORDER);
        g.fillOval(xIndent, yIndent, SIZE - 1, SIZE - 1);
    }

    @Override
    public void update() {
        updateMain();

        { // передвигаемся по полю с шагом 1 по умолчанию
            // список доступных направлений для перемещения
            List<Position> availableDir = Arrays.stream(Direction.values())
                    .map(direction -> getPosition().next(direction))
                    .filter(newPos -> !newPos.isScope(0, 0, island.getWidth(), island.getHeight())).toList();
            // если нет доступных перемещений выходим
            if (availableDir.isEmpty()) {
                return;
            }
            // выбераем одно рандомное направление
            Position newPosition = availableDir.get(ThreadLocalRandom.current().nextInt(availableDir.size()));
            setPosition(newPosition); // задаем его
        }

        { //если еда в нашей клетке то седаем ее
            //получаем список всех позиций которые равны позиции волка
            List<LivingUnit> neighbours = island.getUnits().stream().filter(unit -> unit.getPosition().equals(this.getPosition())).toList();

            // проверяем список на возможность быть сединым
            // далее выбераем любого из них
            // если обект есть то убиваем его и повышаем свое здоровье на 50 балов
            neighbours.stream()
                    .filter(unit -> this.isEatable(unit.getClass()))
                    .findAny()
                    .ifPresent(unit -> {
                        unit.kill();
                        LOGGER.debug("A Wolf[{}] on {} is eating", health, getPosition());
                        health.setCurrent(health.getCurrent() + Rabbit.FOOD_VALUE);
                    });

            //если текущий пол женский
            // то из списка позиций проверяем что рядом волк
            // если этот волк не женского пола  то получаем тру иначе фолс
            //берем первого попавшегося волка мужского пола
            // спариваемся и  получаем нового волка с вероятностью до 30% второго
            if (this.sex == Sex.FEMALE) {
                neighbours.stream()
                        .filter(unit -> {
                            if (unit instanceof Wolf wolf) {
                                return wolf.sex != this.sex;
                            }
                            return false;
                        })
                        .findAny()
                        .ifPresent(mate -> {
                            do {
                                birth(new Wolf(island, getPosition(), Sex.random()));
                                LOGGER.debug("New wolf was born on {}", getPosition());
                            } while (ThreadLocalRandom.current().nextDouble() < BIRTH_RATE);
                        });
            }
        }
    }

    @Override
    void updateHealth() {
        health.setCurrent(health.getCurrent() - 1);
    }
}
