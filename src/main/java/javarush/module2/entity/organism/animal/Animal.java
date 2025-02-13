package javarush.module2.entity.organism.animal;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.abstarction.entity.Dies;
import javarush.module2.abstarction.entity.Eats;
import javarush.module2.abstarction.entity.Movable;
import javarush.module2.entity.organism.Organism;

import java.util.Random;

public abstract class Animal extends Organism implements Movable, Eats, Dies {

    protected AnimalAttributes attributes;
    protected double currentHunger;
    protected Random random = new Random();

    public Animal(AnimalAttributes attributes) {

        this.attributes = attributes;
        this.currentHunger = 0;
    }
    @Override
    public void die(){
        System.out.println(STR."\{this.getClass().getSimpleName()} помер від голоду.");
    }
}
