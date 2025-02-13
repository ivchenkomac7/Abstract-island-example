package javarush.module2;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.AnimalConfigLoader;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.organism.animal.herbivore.Rabbit;
import javarush.module2.entity.organism.animal.predator.Wolf;


import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Island island = new Island(10, 10);

        Map<String, AnimalAttributes> predators = AnimalConfigLoader.loadPredators();
        Map<String, AnimalAttributes> herbivores = AnimalConfigLoader.loadHerbivores();

        if (predators.containsKey("Wolf")) {
            Wolf wolf = new Wolf(predators.get("Wolf"));
            wolf.eat(null);
            wolf.move(island);
            wolf.reproduce(null);
        }

        if (herbivores.containsKey("Rabbit")) {
            Rabbit rabbit = new Rabbit(herbivores.get("Rabbit"));
            rabbit.eat(null);
            rabbit.move(island);
            rabbit.reproduce(null);
        }

    }
}
