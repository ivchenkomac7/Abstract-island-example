package javarush.module2.entity.organism.animal.herbivore;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.map.Island;

public class Rabbit extends Herbivore{
    public Rabbit(AnimalAttributes attributes, int x, int y) {
        super(attributes, x, y);
    }
    @Override
    public void eat(Island island) {
        System.out.println("Кролик їсть траву");
    }

    @Override
    public void move(Island island){
        System.out.println("Кролик стрибає на сусідню клітинку.");
    }


}
