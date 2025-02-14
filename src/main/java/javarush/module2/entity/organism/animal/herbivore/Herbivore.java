package javarush.module2.entity.organism.animal.herbivore;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.animal.Animal;
import javarush.module2.entity.organism.plant.Grass;

public abstract class Herbivore extends Animal {
    public Herbivore(AnimalAttributes attributes, int x, int y) {
        super(attributes, x , y);
    }
    @Override
    public void eat(Island island) {
        Location location = island.getLocation(x, y);
        Grass grass = location.getGrass(); // Отримуємо об'єкт трави

        if (grass != null && grass.getAmount() > 0) {
            double eaten = Math.min(grass.getAmount(), this.attributes.foodNeeded);
            grass.decreaseAmount(eaten); // Зменшуємо кількість трави
            System.out.println(this.getClass().getSimpleName() + " їсть " + eaten + " одиниць трави на (" + x + ", " + y + ")");
        } else {
            System.out.println(this.getClass().getSimpleName() + " не знайшов трави на (" + x + ", " + y + ")");
        }
    }
}
