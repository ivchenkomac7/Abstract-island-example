package javarush.module2.entity.organism.animal.predator;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.Organism;

public class Wolf extends Predator{
    public Wolf(AnimalAttributes attributes) {
        super(attributes);
    }
    @Override
    public void eat(Location location) {
        System.out.println("Вовк їсть свою здобич");
    }
    @Override
    public Organism reproduce(Location location) {
        System.out.println("Вовк знаходить пару та розмножується");
        return null;
    }

    @Override
    public void move(Island island) {
        System.out.println("Вовк переміщується на нову клітинку.");
    }
}
