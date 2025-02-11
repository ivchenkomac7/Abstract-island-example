package javarush.module2.entity.organism.animal.herbivore;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.organism.animal.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(AnimalAttributes attributes) {
        super(attributes);
    }
}
