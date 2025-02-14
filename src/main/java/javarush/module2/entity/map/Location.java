package javarush.module2.entity.map;

import javarush.module2.entity.organism.animal.Animal;
import javarush.module2.entity.organism.plant.Grass;


import java.util.ArrayList;
import java.util.List;


// Клас клітинки острова
public class Location {
    private Grass grass;
    List<Animal> animals = new ArrayList<>();


    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }



    public Location(double initialGrass) {
        this.grass = new Grass(initialGrass);
    }

    public Grass getGrass() {
        return grass;
    }
}
