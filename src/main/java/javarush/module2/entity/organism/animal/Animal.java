package javarush.module2.entity.organism.animal;

import javarush.module2.GameConfigurators.AnimalAttributes;
import javarush.module2.abstarction.entity.Dies;
import javarush.module2.abstarction.entity.Eats;
import javarush.module2.abstarction.entity.Movable;
import javarush.module2.entity.map.Island;
import javarush.module2.entity.map.Location;
import javarush.module2.entity.organism.Organism;

import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism implements Movable, Eats, Dies {

    protected AnimalAttributes attributes;
    protected double currentHunger;
    protected int x, y;
    protected Random random = new Random();

    public Animal(AnimalAttributes attributes, int x, int y) {

        this.attributes = attributes;
        this.x = x;
        this.y = y;
        this.currentHunger = 0;
    }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void die(){
        System.out.println(STR."\{this.getClass().getSimpleName()} помер від голоду.");
    }
    @Override
    public void move(Island island) {
        Random rand = new Random();
        int newX = Math.max(0, Math.min(island.getWidth() - 1, x + rand.nextInt(2 * attributes.speed + 1) - attributes.speed));
        int newY = Math.max(0, Math.min(island.getHeight() - 1, y + rand.nextInt(2 * attributes.speed + 1) - attributes.speed));

        island.moveAnimal(this, x, y, newX, newY);
        setPosition(newX, newY);
        System.out.println("Вовк рухається до " + newX + ", " + newY);
        }
    }
