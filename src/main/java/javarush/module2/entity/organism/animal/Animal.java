package javarush.module2.entity.organism.animal;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.abstarction.entity.Eats;
import javarush.module2.abstarction.entity.Movable;
import javarush.module2.entity.organism.Organism;

public abstract class Animal extends Organism implements Movable, Eats {

    protected double weight;
    protected int maxCountPerCell;
    protected int speed;
    protected double foodNeeded;

    public Animal(AnimalAttributes attributes) {

        this.weight = attributes.getWeight();
        this.maxCountPerCell = attributes.getMaxCountPerCell();
        this.speed = attributes.getSpeed();
        this.foodNeeded = attributes.getFoodNeeded();
    }
}
