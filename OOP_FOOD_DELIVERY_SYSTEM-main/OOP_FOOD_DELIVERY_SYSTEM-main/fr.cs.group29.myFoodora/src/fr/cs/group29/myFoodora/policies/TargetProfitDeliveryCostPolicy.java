package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.MyFoodoraSystem;

public class TargetProfitDeliveryCostPolicy extends ProfitPolicy {

    private double targetProfit;

    // Constructor
    public TargetProfitDeliveryCostPolicy(double targetProfit) {
        this.targetProfit = targetProfit;
    }

    // Implement applyPolicy method
    @Override
    public void applyPolicy() {
        MyFoodoraSystem system = MyFoodoraSystem.getInstance();
        double totalIncome = system.computeTotalIncome();
        double currentCost = system.getDeliveryCost();
        double newDeliveryCost = currentCost + (targetProfit / totalIncome);

        system.setDeliveryCost(newDeliveryCost);
        System.out.println("Delivery cost updated to " + newDeliveryCost + " to meet target profit of " + targetProfit);
    }

    // Implement abstract method
    @Override
    public void calculateParameters(MyFoodoraSystem system) {
        applyPolicy();
    }

    // Getter and Setter
    public double getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(double targetProfit) {
        this.targetProfit = targetProfit;
    }
}
