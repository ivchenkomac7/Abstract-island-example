package javarush.module2;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.AnimalConfigLoader;
import javarush.module2.GameConfigurators.FoodChainLoader;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.animal.Animal;
import javarush.module2.entity.organism.animal.herbivore.Rabbit;
import javarush.module2.entity.organism.animal.predator.Wolf;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Запуск симуляції острова...");

        // Завантаження конфігурацій
        Map<String, AnimalAttributes> predators = AnimalConfigLoader.loadPredators();
        Map<String, AnimalAttributes> herbivores = AnimalConfigLoader.loadHerbivores();

        // Створення острова
        Island island = new Island(5, 5);

        // Створення тварин
        Wolf wolf = new Wolf(predators.get("Wolf"), 2, 2);
        Rabbit rabbit = new Rabbit(herbivores.get("Rabbit"), 2, 2);
        Rabbit rabbit2 = new Rabbit(herbivores.get("Rabbit"), 1, 2);
        Rabbit rabbit3 = new Rabbit(herbivores.get("Rabbit"), 2, 1);

        // Додавання тварин
//        island.getLocation(2, 2).addAnimal(wolf);
        island.getLocation(2, 2).addAnimal(rabbit);
//        island.getLocation(2, 1).addAnimal(rabbit);
//        island.getLocation(1, 1).addAnimal(rabbit);
//        island.getLocation(2, 3).addAnimal(rabbit);

        // Симуляція 5 тактів
        for (int i = 0; i < 5; i++) {
            System.out.println("Такт " + (i + 1));

            // Всі тварини їдять, рухаються, перевіряють голод
            List<Animal> animals = new ArrayList<>(island.getLocation(2, 2).getAnimals());
            for (Animal animal : animals) {
                animal.eat(island);
                animal.move(island);
                animal.updateState(island);
            }

            System.out.println();
        }

        System.out.println("Симуляція завершена.");
    }
}
