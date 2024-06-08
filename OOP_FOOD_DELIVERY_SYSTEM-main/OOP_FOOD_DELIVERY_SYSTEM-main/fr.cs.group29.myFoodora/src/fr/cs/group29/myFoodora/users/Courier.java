package fr.cs.group29.myFoodora.users;

import fr.cs.group29.myFoodora.common.*;

public class Courier extends User {
    private String currentPosition;
    private boolean onDuty;
    private int deliveryCount;
    private Order currentOrder;

    public Courier(String username, String password, String firstName, String lastName, String currentPosition) {
        super(username, password, firstName, lastName);
        this.currentPosition = currentPosition;
        this.onDuty = false;
        this.deliveryCount = 0;
    }

    public void setOnDuty() {
        this.onDuty = true;
    }

    public void setOffDuty() {
        this.onDuty = false;
    }

    public void updatePosition(String newPosition) {
        this.currentPosition = newPosition;
    }

    public boolean isAvailable() {
        return onDuty && currentOrder == null;
    }

    public void assignOrder(Order order) {
        if (isAvailable()) {
            this.currentOrder = order;
            System.out.println("Order assigned to courier: " + this.getUsername());
        } else {
            System.out.println("Courier " + this.getUsername() + " is not available.");
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public int getDeliveryCount() {
        return deliveryCount;
    }

    public void incrementDeliveryCount() {
        this.deliveryCount++;
    }

    @Override
    public void displayUserRole() {
        System.out.println("Role: Courier");
    }
}
