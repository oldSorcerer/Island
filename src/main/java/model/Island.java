package model;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static model.Cell.SIZE;

public class Island {

    @Getter
    private final int width;
    @Getter
    private final int height;

    private final List<Cell> cells;
    private final List<DrawableUnit> units = new ArrayList<>();

    private Island(int width, int height, List<Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public static Island create(int width, int height) {
        ArrayList<Cell> cells = new ArrayList<>(width * height);
        IntStream.range(0, width * height).forEach(i -> cells.add(new Cell(i % width, i / width)));
        return new Island(width, height, cells);
    }

    public void update() {
        units.forEach(DrawableUnit::update);
    }

    public void draw(Graphics2D g) {
        cells.forEach(cell -> cell.draw(g));
        units.forEach(unit ->
                unit.draw((Graphics2D) g.create(
                        unit.getPosition().getX() * SIZE,
                        unit.getPosition().getY() * SIZE,
                        SIZE - 1,
                        SIZE - 1)
                )
        );
    }

    public void addUnit(DrawableUnit drawableUnit) {
        units.add(drawableUnit);
    }
}
