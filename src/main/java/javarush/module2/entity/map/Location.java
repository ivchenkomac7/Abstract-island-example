package javarush.module2.entity.map;

import javarush.module2.entity.organism.animal.Animal;


import java.util.ArrayList;
import java.util.List;


// Клас клітинки острова
public class Location {
    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
