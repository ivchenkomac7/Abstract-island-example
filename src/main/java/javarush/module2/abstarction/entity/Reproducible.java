package javarush.module2.abstarction.entity;

import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.Organism;

public interface Reproducible {
    Organism reproduce(Location location);
}
