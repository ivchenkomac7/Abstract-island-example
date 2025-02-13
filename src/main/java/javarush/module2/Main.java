package javarush.module2;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.AnimalConfigLoader;
import javarush.module2.GameConfigurators.FoodChainLoader;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.animal.Animal;
import javarush.module2.entity.organism.animal.herbivore.Rabbit;
import javarush.module2.entity.organism.animal.predator.Wolf;


import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Запуск симуляції острова...");

        // Завантаження конфігурацій тварин
        Map<String, AnimalAttributes> predators = AnimalConfigLoader.loadPredators();
        Map<String, AnimalAttributes> herbivores = AnimalConfigLoader.loadHerbivores();

        // Завантаження харчового ланцюга
        Map<String, Map<String, Double>> foodChain = FoodChainLoader.loadFoodChain();

        // Створення острова
        Island island = new Island(5, 5);

        // Створення тварин
        Wolf wolf = new Wolf(predators.get("Wolf"), 2, 2);
        Rabbit rabbit = new Rabbit(herbivores.get("Rabbit"), 2, 3);

        // Додавання тварин на локації
        island.getLocation(2, 2).addAnimal(wolf);
        island.getLocation(2, 3).addAnimal(rabbit);

        // Симуляція поведінки
        wolf.eat();
        wolf.move(island);
        wolf.reproduce();

        rabbit.eat();
        rabbit.move(island);
        rabbit.reproduce();

        System.out.println("Симуляція завершена.");
    }
}
