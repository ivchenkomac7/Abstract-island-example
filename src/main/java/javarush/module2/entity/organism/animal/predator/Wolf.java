package javarush.module2.entity.organism.animal.predator;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.Organism;

public class Wolf extends Predator{
    public Wolf(AnimalAttributes attributes, int x, int y) {
        super(attributes, x, y);
    }
    @Override
    public void eat(Island island) {
        System.out.println("Вовк їсть свою здобич");
    }

    @Override
    public void move(Island island) {
        System.out.println("Вовк переміщується на нову клітинку.");
    }
}
