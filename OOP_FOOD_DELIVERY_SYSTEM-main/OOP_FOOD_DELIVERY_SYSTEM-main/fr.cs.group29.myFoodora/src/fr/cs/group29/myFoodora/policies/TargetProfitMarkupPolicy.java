package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.MyFoodoraSystem;

public class TargetProfitMarkupPolicy extends ProfitPolicy {

    private double targetProfit;

    // Constructor
    public TargetProfitMarkupPolicy(double targetProfit) {
        this.targetProfit = targetProfit;
    }

    // Implement applyPolicy method
    @Override
    public void applyPolicy() {
        MyFoodoraSystem system = MyFoodoraSystem.getInstance();
        double totalIncome = system.computeTotalIncome();
        double currentMarkup = system.getMarkupPercentage();
        double newMarkupPercentage = currentMarkup + (targetProfit / totalIncome);

        system.setMarkupPercentage(newMarkupPercentage);
        System.out.println("Markup percentage updated to " + newMarkupPercentage + " to meet target profit of " + targetProfit);
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
