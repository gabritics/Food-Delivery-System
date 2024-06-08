package fr.cs.group29.myFoodora.users;

import java.util.ArrayList;
import  fr.cs.group29.myFoodora.common.*;
import fr.cs.group29.myFoodora.fidelity.FidelityCard;
import fr.cs.group29.myFoodora.fidelity.PointFidelityCard;

import java.util.List;

// Customer class extending User
public class Customer extends User {
    // Attributes
    private String address;
    private String email;
    private String phoneNumber;
    private List<Order> orders;
    private FidelityCard fidelityCard;
    private boolean notificationsConsent;

    // Constructor
    public Customer(String username, String password, String firstName, String lastName,
                    String address, String email, String phoneNumber) {
        super(username, password, firstName, lastName);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orders = new ArrayList<>();
        this.notificationsConsent = false; // Default to not consenting
    }

    // Display user role
    @Override
    public void displayUserRole() {
        System.out.println("Role: Customer");
    }

    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public FidelityCard getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
    }

    public boolean hasNotificationsConsent() {
        return notificationsConsent;
    }

    public void setNotificationsConsent(boolean notificationsConsent) {
        this.notificationsConsent = notificationsConsent;
    }

    // Methods
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully.");
    }

    public void registerFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
        System.out.println("Fidelity card registered.");
    }

    public void unregisterFidelityCard() {
        this.fidelityCard = null;
        System.out.println("Fidelity card unregistered.");
    }

    public List<Order> getOrderHistory() {
        return orders;
    }

    public int getFidelityPoints() {
        if (fidelityCard instanceof PointFidelityCard) {
            return ((PointFidelityCard) fidelityCard).getPoints();
        }
        return 0;
    }

    public void subscribeToOffers() {
        notificationsConsent = true;
        System.out.println("Subscribed to special offers notifications.");
    }

    public void unsubscribeFromOffers() {
        notificationsConsent = false;
        System.out.println("Unsubscribed from special offers notifications.");
    }

    public void updateNotificationsConsent(boolean consent) {
        this.notificationsConsent = consent;
        String status = consent ? "Subscribed" : "Unsubscribed";
        System.out.println(status + " to special offers notifications.");
    }
}
