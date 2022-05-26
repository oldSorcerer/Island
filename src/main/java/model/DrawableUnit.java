package model;

import java.awt.*;

public interface DrawableUnit {

    void draw(Graphics2D g);

    void update();

    Position getPosition();
}
