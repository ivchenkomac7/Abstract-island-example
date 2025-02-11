package javarush.module2.entity.organism.animal.herbivore;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.organism.Organism;

public class Rabbit extends Herbivore{
    public Rabbit(AnimalAttributes attributes) {
        super(attributes);
    }
    @Override
    public void eat() {
        System.out.println("Кролик їсть траву");
    }
    @Override
    public Organism reproduce() {
        System.out.println("Кролик швидко розмножується");
        return null;
    }
    @Override
    public void move(){
        System.out.println("Кролик стрибає на " + speed + " клітинок");
    }
}
