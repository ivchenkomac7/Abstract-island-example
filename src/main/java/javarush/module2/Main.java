package javarush.module2;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.AnimalConfigLoader;
import javarush.module2.GameConfigurators.FoodChainLoader;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.organism.animal.Animal;
import javarush.module2.entity.organism.animal.herbivore.Rabbit;
import javarush.module2.entity.organism.animal.predator.Wolf;


import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Island island = new Island(10, 10);

        Map<String, AnimalAttributes> predators = AnimalConfigLoader.loadPredators();
        Map<String, AnimalAttributes> herbivores = AnimalConfigLoader.loadHerbivores();
        Map<String, Map<String, Double>> foodChain = FoodChainLoader.loadFoodChain();
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
        if (predators.containsKey("Wolf")) {
            Wolf wolf = new Wolf(predators.get("Wolf"));
            System.out.println("Створено вовка з параметрами: " + predators.get("Wolf"));
        }
    }
}
