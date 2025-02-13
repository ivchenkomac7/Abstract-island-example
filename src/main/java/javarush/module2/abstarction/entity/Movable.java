package javarush.module2.abstarction.entity;

import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;

public interface Movable {
    void move(Island island);
}
