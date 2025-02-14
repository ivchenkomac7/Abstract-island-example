package javarush.module2.entity.organism.animal.predator;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.GameConfigurators.FoodChainLoader;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Predator extends Animal {
    public Predator(AnimalAttributes attributes, int x, int y) {
        super(attributes, x, y);
    }

    @Override
    public void eat(Island island) {
        Location location = island.getLocation(x, y);
        List<Animal> preyList = new ArrayList<>();
        for(Animal animal : location.getAnimals()){
            if(FoodChainLoader.canEat(this.getClass().getSimpleName(), animal.getClass().getSimpleName())){
                preyList.add(animal);
            }
        }
        if (!preyList.isEmpty()){
            Animal prey = preyList.get(random.nextInt(preyList.size())); // Випадкова жертва
            location.removeAnimal(prey);
            System.out.println(this.getClass().getSimpleName() + " з'їв " + prey.getClass().getSimpleName() + " на (" + x + ", " + y + ")");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " не знайшов їжі на (" + x + ", " + y + ")");
        }
    }
}
