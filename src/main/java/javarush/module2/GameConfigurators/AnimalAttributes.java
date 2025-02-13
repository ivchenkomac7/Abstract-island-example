package javarush.module2.GameConfigurators;

// Клас для збереження параметрів тварин
public class AnimalAttributes {
    private final double weight;
    private final int maxCountPerCell;
    private final int speed;
    private final double foodNeeded;

    public AnimalAttributes(double weight, int maxCountPerCell, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
    }
    @Override
    public String toString() {
        return STR."weight = \{weight}, maxCountPerCell = \{maxCountPerCell}, speed = \{speed}, foodNeeded = \{foodNeeded}";
    }

//    public double getWeight() { return weight; }
//    public int getMaxCountPerCell() { return maxCountPerCell; }
//    public int getSpeed() { return speed; }
//    public double getFoodNeeded() { return foodNeeded; }
}