package fr.cs.group29.myFoodora.fidelity;

// PointFidelityCard class extending FidelityCard
public class PointFidelityCard extends FidelityCard {
    // Attributes
    private int points;

    // Constructor
    public PointFidelityCard() {
        super(FidelityCardType.POINT);
        this.points = 0; // Initialize with 0 points
    }

    // Getters and Setters
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Implement abstract methods
    @Override
    public double applyDiscount(double price) {
        // Points are converted to a discount (e.g., 1 point = $1 discount)
        double discount = Math.min(points, price);
        points -= discount;
        return price - discount;
    }

    @Override
    public void addPoints(double price) {
        // Assume 1 point per $10 spent
        points += (int) (price / 10);
        System.out.println("Points added. Total points: " + points);
    }
}
