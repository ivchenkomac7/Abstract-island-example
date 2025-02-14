package javarush.module2.entity.organism.plant;

import javarush.module2.entity.map.Island;

public class Grass extends Plant{
    private double amount; // Поточна кількість трави
    private static final double MAX_AMOUNT = 200.0; // Фіксоване максимальне значення

    public Grass(double initialAmount) {
        this.amount = Math.min(initialAmount, MAX_AMOUNT); // Обмежуємо початкову кількість
    }

    public double getAmount() {
        return amount;
    }

    public void decreaseAmount(double amountEaten) {
        this.amount = Math.max(0, this.amount - amountEaten);
    }

    public void grow(double growthRate) {
        this.amount = Math.min(this.amount + growthRate, MAX_AMOUNT); // Не перевищуємо максимум
    }

    public static double getMaxAmount() {
        return MAX_AMOUNT;
    }

    @Override
    public void reproduce(Island island) {
    }
    @Override
    public void updateState(Island island){
    }


}
