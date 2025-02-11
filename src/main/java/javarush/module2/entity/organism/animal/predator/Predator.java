package javarush.module2.entity.organism.animal.predator;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.organism.Organism;
import javarush.module2.entity.organism.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(AnimalAttributes attributes) {
        super(attributes);
    }
}
