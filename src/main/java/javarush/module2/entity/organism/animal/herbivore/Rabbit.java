package javarush.module2.entity.organism.animal.herbivore;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.Organism;

public class Rabbit extends Herbivore{
    public Rabbit(AnimalAttributes attributes) {
        super(attributes);
    }
    @Override
    public void eat(Location location) {
        System.out.println("Кролик їсть траву");
    }
    @Override
    public Organism reproduce(Location location) {
        System.out.println("Кролик швидко розмножується");
        return null;
    }
    @Override
    public void move(Island island){
        System.out.println("Кролик стрибає на сусідню клітинку.");
    }


}
