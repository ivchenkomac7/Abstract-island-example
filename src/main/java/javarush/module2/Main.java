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

        // Створення острова
        Island island = new Island(5, 5);

        // Створення тварин
        Wolf wolf1 = new Wolf(predators.get("Wolf"), 2, 2);
        Wolf wolf2 = new Wolf(predators.get("Wolf"), 2, 2);
        Rabbit rabbit1 = new Rabbit(herbivores.get("Rabbit"), 2, 3);

        // Додавання тварин у локації
        island.getLocation(2, 2).addAnimal(wolf1);
        island.getLocation(2, 2).addAnimal(wolf2);
        island.getLocation(2, 3).addAnimal(rabbit1);

        // Симуляція декількох тактів
        for (int i = 0; i < 5; i++) {
            System.out.println("Такт " + (i + 1));
            wolf1.eat();
            wolf1.move(island);
            wolf1.reproduce(island);

            rabbit1.eat();
            rabbit1.move(island);
            rabbit1.reproduce(island);
        }

        System.out.println("Симуляція завершена.");
    }
}
