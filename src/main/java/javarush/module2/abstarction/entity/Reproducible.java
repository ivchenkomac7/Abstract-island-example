package javarush.module2.abstarction.entity;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.organism.Organism;

public interface Reproducible {
    void reproduce(Island island);
}
