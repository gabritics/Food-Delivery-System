package fr.cs.group29.myFoodora.fidelity;

// Abstract FidelityCard class
public abstract class FidelityCard {
    // Attributes
    private FidelityCardType type;

    // Constructor
    public FidelityCard(FidelityCardType type) {
        this.type = type;
    }

    // Getters and Setters
    public FidelityCardType getType() {
        return type;
    }

    public void setType(FidelityCardType type) {
        this.type = type;
    }

    // Abstract Methods
    public abstract double applyDiscount(double price);

    public abstract void addPoints(double price);
}
