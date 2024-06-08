package fr.cs.group29.myFoodora.fidelity;

// BasicFidelityCard class extending FidelityCard
public class BasicFidelityCard extends FidelityCard {

    // Constructor
    public BasicFidelityCard() {
        super(FidelityCardType.BASIC);
    }

    // Implement abstract methods
    @Override
    public double applyDiscount(double price) {
        // Basic fidelity card applies a flat 5% discount
        return price * 0.95;
    }

    @Override
    public void addPoints(double price) {
        // No points for BasicFidelityCard
        System.out.println("BasicFidelityCard does not accumulate points.");
    }
}
