package fr.cs.group29.myFoodora.common;
import fr.cs.group29.myFoodora.users.*;
import java.util.ArrayList;
import java.util.List;

// Order class
public class Order {
    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private static List<Dish> items;
    private static List<Meal> meals;
    private double totalPrice;
    private OrderStatus status;
    private Courier courier;

    public Order(String id, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.meals = new ArrayList<>();
        this.totalPrice = 0.0;
        this.status = OrderStatus.PLACED;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public static List<Dish> getItems() {
        return items;
    }

    public void setItems(List<Dish> items) {
        this.items = items;
        computeTotalPrice();
    }

    public static List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
        computeTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    // Methods
    public void addItem(Dish dish) {
        items.add(dish);
        computeTotalPrice();
        System.out.println("Dish " + dish.getName() + " added to the order.");
    }

    public void removeItem(String dishName) {
        items.removeIf(dish -> dish.getName().equals(dishName));
        computeTotalPrice();
        System.out.println("Dish " + dishName + " removed from the order.");
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
        computeTotalPrice();
        System.out.println("Meal " + meal.getName() + " added to the order.");
    }

    public void removeMeal(String mealName) {
        meals.removeIf(meal -> meal.getName().equals(mealName));
        computeTotalPrice();
        System.out.println("Meal " + mealName + " removed from the order.");
    }

    public void finalizeOrder() {
        if (items.isEmpty() && meals.isEmpty()) {
            System.out.println("Order cannot be finalized. No items or meals added.");
            return;
        }
        this.status = OrderStatus.DELIVERED;
        System.out.println("Order " + id + " finalized.");
    }

    public void computeTotalPrice() {
        this.totalPrice = items.stream().mapToDouble(Dish::getPrice).sum()
                + meals.stream().mapToDouble(meal -> meal.isSpecialOffer() ? meal.getSpecialOfferPrice() : meal.getDefaultPrice()).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer=" + customer.getUsername() +
                ", restaurant=" + restaurant.getName() +
                ", items=" + items +
                ", meals=" + meals +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", courier=" + (courier != null ? courier.getUsername() : "None") +
                '}';
    }
}
