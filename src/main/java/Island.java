import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Island {

    int width;
    int height;

    List<Cell> cells;
    List<Movable> units = new ArrayList<>();

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
        units.forEach(Movable::move);
    }


    public void islandViewer(){
        System.out.print("Animals %d Herbivores %d Predators %d Plants %d ");
        System.out.println();

    }

    public static void main(String[] args) {
        Island island = Island.create(5, 5);
        island.islandViewer();
    }

}
