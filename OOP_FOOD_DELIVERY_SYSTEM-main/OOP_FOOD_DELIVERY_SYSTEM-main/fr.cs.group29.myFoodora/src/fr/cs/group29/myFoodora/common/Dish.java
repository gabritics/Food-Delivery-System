package fr.cs.group29.myFoodora.common;

// Dish class
public class Dish {
    // Attributes
    private String name;
    private DishCategory category;
    private DishType type;
    private double price;

    // Constructor
    public Dish(String name, DishCategory category, DishType type, double price) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.price = price;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Methods
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
