package fr.cs.group29.myFoodora.fidelity;

import java.util.Random;

// LotteryFidelityCard class extending FidelityCard
public class LotteryFidelityCard extends FidelityCard {
    private Random random;

    // Constructor
    public LotteryFidelityCard() {
        super(FidelityCardType.LOTTERY);
        this.random = new Random();
    }

    // Implement abstract methods
    @Override
    public double applyDiscount(double price) {
        // Lottery card gives a random discount chance (e.g., 1 in 10 chance to get a free meal)
        if (random.nextInt(10) == 0) { // 10% chance
            System.out.println("Congratulations! You get this meal for free.");
            return 0;
        }
        return price;
    }

    @Override
    public void addPoints(double price) {
        // No points for LotteryFidelityCard
        System.out.println("LotteryFidelityCard does not accumulate points.");
    }
}
