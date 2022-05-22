package model;

public class Cell {

   // List<Herbivorous> herbivorous = new ArrayList<>();

    Position position;

    public Cell(int x, int y) {
        this.position = Position.now(x, y);
    }
}
