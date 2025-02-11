package javarush.module2;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.AnimalConfigLoader;
import javarush.module2.entity.organism.animal.herbivore.Rabbit;
import javarush.module2.entity.organism.animal.predator.Wolf;


import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, AnimalAttributes> predators = AnimalConfigLoader.loadPredators();
        Map<String, AnimalAttributes> herbivores = AnimalConfigLoader.loadHerbivores();

        Wolf wolf = new Wolf(predators.get("Wolf"));
        Rabbit rabbit = new Rabbit(herbivores.get("Rabbit"));

        wolf.eat();
        wolf.move();
        wolf.reproduce();

        rabbit.eat();
        rabbit.move();
        rabbit.reproduce();

    }
}
