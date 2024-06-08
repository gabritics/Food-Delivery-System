package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.MyFoodoraSystem;

public class TargetProfitServiceFeePolicy extends ProfitPolicy {

    private double targetProfit;

    // Constructor
    public TargetProfitServiceFeePolicy(double targetProfit) {
        this.targetProfit = targetProfit;
    }

    // Implement applyPolicy method
    @Override
    public void applyPolicy() {
        MyFoodoraSystem system = MyFoodoraSystem.getInstance();
        double totalIncome = system.computeTotalIncome();
        double currentFee = system.getServiceFee();
        double newServiceFee = currentFee + (targetProfit / totalIncome);

        system.setServiceFee(newServiceFee);
        System.out.println("Service fee updated to " + newServiceFee + " to meet target profit of " + targetProfit);
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
