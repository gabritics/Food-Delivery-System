package fr.cs.group29.myFoodora.common;
import fr.cs.group29.myFoodora.policies.DeliveryPolicy;
import fr.cs.group29.myFoodora.policies.ProfitPolicy;
import fr.cs.group29.myFoodora.users.*;
import java.util.ArrayList;
import java.util.List;

// Singleton class for MyFoodoraSystem
public class MyFoodoraSystem {
    // Attributes
    private static MyFoodoraSystem instance;
    private List<Manager> managers;
    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<Courier> couriers;
    private List<Order> orders;
    private double serviceFee;
    private double markupPercentage;
    private double deliveryCost;
    private DeliveryPolicy deliveryPolicy;
    private ProfitPolicy profitPolicy;
    private NotificationSystem notificationSystem;

    // Private constructor to prevent instantiation
    private MyFoodoraSystem() {
        this.managers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.couriers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.serviceFee = 2.0; // Default service fee
        this.markupPercentage = 0.05; // Default markup percentage (5%)
        this.deliveryCost = 5.0; // Default delivery cost
        this.notificationSystem = new NotificationSystem();
    }

    // Public method to provide access to the singleton instance
    public static synchronized MyFoodoraSystem getInstance() {
        if (instance == null) {
            instance = new MyFoodoraSystem();
        }
        return instance;
    }

    // Getters and Setters
    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getMarkupPercentage() {
        return markupPercentage;
    }

    public void setMarkupPercentage(double markupPercentage) {
        this.markupPercentage = markupPercentage;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public DeliveryPolicy getDeliveryPolicy() {
        return deliveryPolicy;
    }

    public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
        this.deliveryPolicy = deliveryPolicy;
    }

    public ProfitPolicy getProfitPolicy() {
        return profitPolicy;
    }

    public void setProfitPolicy(ProfitPolicy profitPolicy) {
        this.profitPolicy = profitPolicy;
    }

    public NotificationSystem getNotificationSystem() {
        return notificationSystem;
    }

    public void setNotificationSystem(NotificationSystem notificationSystem) {
        this.notificationSystem = notificationSystem;
    }

    // Methods
    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void allocateCourier(Order order) {
        if (deliveryPolicy != null) {
            deliveryPolicy.assignCourier(order);
        } else {
            System.out.println("No delivery policy set. Courier not allocated.");
        }
    }

    public double computeTotalIncome() {
        return orders.stream().mapToDouble(Order::getTotalPrice).sum();
    }

    public double computeProfit() {
        return orders.stream()
                .mapToDouble(order -> (order.getTotalPrice() * markupPercentage + serviceFee - deliveryCost))
                .sum();
    }

    public void notifySpecialOffers(String offerDetails) {
        notificationSystem.sendSpecialOfferNotification(offerDetails);
    }
}
