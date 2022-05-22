import java.awt.*;
import java.util.Random;

public class Helper {

    public static void main(String[] args) {
        Animals rab1 = new model.herbivores.Rabbit();
        int [][] fieldVisual = new int[20][20];
        printField(fieldVisual, rab1);

    }

    static void printField(int [][] fieldVisual, Animals animals) {
        for (int y = 0; y < fieldVisual.length; y++) {
            for (int x = 0; x < fieldVisual[y].length; x++) {
                if (x == animals.getPosition().x && y == animals.getPosition().y)
                    System.out.print(" " + animals.getName() + " |");
                else System.out.print("   |");
            }
            System.out.println();
        }
    }

}

abstract class Animals {
    private char name;
    private int limitX = 20;
    private int limitY = 20;
    private Point position;
    private Random probability = new Random(System.currentTimeMillis());
    private int life = 10;
    private char [] direction = {'u','d','l','r'};

    Animals(Point position, char name) {
        this.position = position;
        this.name = name;
    }

    Animals(char name) {
        this.position = new Point();
        position.x = probability.nextInt(limitX);
        position.y = probability.nextInt(limitY);
        this.name = name;
    }

    abstract boolean isMove();

    void move() {
        switch (getDirection()) {
            case  'd' : {
                if (position.y + 1 < limitY) position.y++;
                else position.y = 0;
                break;
            }
            case  'u' : {
                if (position.y - 1 > 0) position.y--;
                else position.y = limitY - 1;
                break;
            }
            case  'r' : {
                if (position.x + 1 < limitX) position.x++;
                else position.x = 0;
                break;
            }
            case  'l' : {
                if (position.x - 1 > 0) position.x--;
                else position.x = limitX - 1;
                break;
            }
        }
    }

    boolean isLife(){
        return life > 0;
    }

    char getName() {
        return name;
    }

    Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    int getProbability() {
        return probability.nextInt(10*limitX*limitY);
    }

    char getDirection() {
        return direction[probability.nextInt(4)];
    }

    public int getLimitX() {
        return limitX;
    }

    public int getLimitY() {
        return limitY;
    }
}

class Rabbit extends Animals {
    private int chanceMove = 3;

    public Rabbit(Point initPosition) {
        super(initPosition, 'R');
    }

    public Rabbit() {
        super('R');
    }

    void move() {
        if (isMove()) {
            super.move();
        }
    }

    @Override
    boolean isMove() {
        return super.getProbability() % chanceMove == 0;
    }
}