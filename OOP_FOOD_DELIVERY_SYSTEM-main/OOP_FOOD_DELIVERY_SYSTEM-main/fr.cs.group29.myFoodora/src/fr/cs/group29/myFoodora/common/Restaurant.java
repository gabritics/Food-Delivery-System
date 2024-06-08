package fr.cs.group29.myFoodora.common;

import java.util.ArrayList;
import java.util.List;

// Restaurant class
public class Restaurant {
	// Attributes
	private String id;
	private String name;
	private String location;
	private String username;
	private String password;
	private List<Dish> menu;
	private List<Meal> meals;
	private double genericDiscountFactor;
	private double specialDiscountFactor;

	// Constructor
	public Restaurant(String name, String location, String username, String password) {
		this.id = IDGenerator.getInstance().generateUniqueID(); // Generates a unique ID
		this.name = name;
		this.location = location;
		this.username = username;
		this.password = password;
		this.menu = new ArrayList<>();
		this.meals = new ArrayList<>();
		this.genericDiscountFactor = 0.05; // Default generic discount factor (5%)
		this.specialDiscountFactor = 0.10; // Default special discount factor (10%)
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Dish> getMenu() {
		return menu;
	}

	public void setMenu(List<Dish> menu) {
		this.menu = menu;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public double getGenericDiscountFactor() {
		return genericDiscountFactor;
	}

	public void setGenericDiscountFactor(double genericDiscountFactor) {
		this.genericDiscountFactor = genericDiscountFactor;
	}

	public double getSpecialDiscountFactor() {
		return specialDiscountFactor;
	}

	public void setSpecialDiscountFactor(double specialDiscountFactor) {
		this.specialDiscountFactor = specialDiscountFactor;
	}

	// Methods
	public void addDish(Dish dish) {
		menu.add(dish);
		System.out.println("Dish " + dish.getName() + " added to the menu.");
	}

	public void removeDish(String dishName) {
		menu.removeIf(dish -> dish.getName().equals(dishName));
		System.out.println("Dish " + dishName + " removed from the menu.");
	}

	public void createMeal(Meal meal) {
		meals.add(meal);
		System.out.println("Meal " + meal.getName() + " created.");
	}

	public void removeMeal(String mealName) {
		meals.removeIf(meal -> meal.getName().equals(mealName));
		System.out.println("Meal " + mealName + " removed.");
	}

	public void setMealOfTheWeek(String mealName) {
		meals.stream()
				.filter(meal -> meal.getName().equals(mealName))
				.findFirst()
				.ifPresent(meal -> {
					meal.setSpecialOffer(true);
					meal.computeSpecialOfferPrice(specialDiscountFactor);
					System.out.println("Meal " + mealName + " set as Meal of the Week with a discount.");
				});
	}

	public void removeMealOfTheWeek(String mealName) {
		meals.stream()
				.filter(meal -> meal.getName().equals(mealName))
				.findFirst()
				.ifPresent(meal -> {
					meal.setSpecialOffer(false);
					meal.computeDefaultPrice();
					System.out.println("Meal " + mealName + " removed from Meal of the Week.");
				});
	}
}
