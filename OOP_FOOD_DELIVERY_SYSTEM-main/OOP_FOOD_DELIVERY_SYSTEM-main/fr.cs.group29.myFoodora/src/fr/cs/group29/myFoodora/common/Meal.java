package fr.cs.group29.myFoodora.common;

import java.util.ArrayList;
import java.util.List;

// Meal class
public class Meal {
	// Attributes
	private String name;
	private List<Dish> items;
	private MealType type;
	private boolean isHalfMeal;
	private boolean isSpecialOffer;
	private double defaultPrice;
	private double specialOfferPrice;

	// Constructor
	public Meal(String name, MealType type, boolean isHalfMeal) {
		this.name = name;
		this.type = type;
		this.isHalfMeal = isHalfMeal;
		this.items = new ArrayList<>();
		this.isSpecialOffer = false; // Default to no special offer
		computeDefaultPrice();
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getItems() {
		return items;
	}

	public void setItems(List<Dish> items) {
		this.items = items;
		computeDefaultPrice(); // Recalculate default price when items change
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}

	public boolean isHalfMeal() {
		return isHalfMeal;
	}

	public void setHalfMeal(boolean halfMeal) {
		isHalfMeal = halfMeal;
	}

	public boolean isSpecialOffer() {
		return isSpecialOffer;
	}

	public void setSpecialOffer(boolean specialOffer) {
		isSpecialOffer = specialOffer;
	}

	public double getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public double getSpecialOfferPrice() {
		return specialOfferPrice;
	}

	public void setSpecialOfferPrice(double specialOfferPrice) {
		this.specialOfferPrice = specialOfferPrice;
	}

	// Methods
	public void addDish(Dish dish) {
		if (isHalfMeal && items.size() >= 2) {
			System.out.println("Cannot add more than 2 dishes to a half-meal.");
			return;
		}
		if (!isHalfMeal && items.size() >= 3) {
			System.out.println("Cannot add more than 3 dishes to a full-meal.");
			return;
		}
		items.add(dish);
		computeDefaultPrice();
	}

	public void removeDish(String dishName) {
		items.removeIf(dish -> dish.getName().equals(dishName));
		computeDefaultPrice();
	}

	public void computeDefaultPrice() {
		this.defaultPrice = items.stream().mapToDouble(Dish::getPrice).sum();
	}

	public void computeSpecialOfferPrice(double discountFactor) {
		this.specialOfferPrice = defaultPrice * (1 - discountFactor);
	}

	@Override
	public String toString() {
		return "Meal{" +
				"name='" + name + '\'' +
				", items=" + items +
				", type=" + type +
				", isHalfMeal=" + isHalfMeal +
				", isSpecialOffer=" + isSpecialOffer +
				", defaultPrice=" + defaultPrice +
				", specialOfferPrice=" + specialOfferPrice +
				'}';
	}
}
