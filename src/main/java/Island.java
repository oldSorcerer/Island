import java.util.List;

public class Island {

    int width;
    int height;

    List<Cell> cells;
    List<Herbivorous> herbivorous;

    private Island(int width, int height, List<Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }
}
