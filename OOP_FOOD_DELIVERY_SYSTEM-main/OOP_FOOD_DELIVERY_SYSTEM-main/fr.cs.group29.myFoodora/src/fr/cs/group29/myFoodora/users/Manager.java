package fr.cs.group29.myFoodora.users;

import  fr.cs.group29.myFoodora.common.*;
import fr.cs.group29.myFoodora.policies.DeliveryPolicy;
import fr.cs.group29.myFoodora.policies.ProfitPolicy;
import fr.cs.group29.myFoodora.policies.ShippedOrderSortingPolicy;

import java.util.List;

// Manager class extending User
public class Manager extends User {

	// Constructor
	public Manager(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}

	// Display user role
	@Override
	public void displayUserRole() {
		System.out.println("Role: Manager");
	}

	// Methods to manage users
	public void addUser(User user, List<User> userList) {
		userList.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " has been added as a " + user.getClass().getSimpleName() + ".");
	}

	public void removeUser(String userId, List<User> userList) {
		userList.removeIf(user -> user.getId().equals(userId));
		System.out.println("User with ID " + userId + " has been removed.");
	}

	// Methods to compute financial metrics
	public double computeTotalIncome(List<Order> orders) {
		return orders.stream().mapToDouble(Order::getTotalPrice).sum();
	}

	public double computeProfit(List<Order> orders, double serviceFee, double markupPercentage, double deliveryCost) {
		return orders.stream()
				.mapToDouble(order -> (order.getTotalPrice() * markupPercentage + serviceFee - deliveryCost))
				.sum();
	}

	// Methods to set financial policies
	public void setServiceFee(MyFoodoraSystem system, double newServiceFee) {
		system.setServiceFee(newServiceFee);
		System.out.println("Service fee has been updated to " + newServiceFee);
	}

	public void setMarkupPercentage(MyFoodoraSystem system, double newMarkupPercentage) {
		system.setMarkupPercentage(newMarkupPercentage);
		System.out.println("Markup percentage has been updated to " + newMarkupPercentage);
	}

	public void setDeliveryCost(MyFoodoraSystem system, double newDeliveryCost) {
		system.setDeliveryCost(newDeliveryCost);
		System.out.println("Delivery cost has been updated to " + newDeliveryCost);
	}

	// Methods to set policies
	public void setDeliveryPolicy(MyFoodoraSystem system, DeliveryPolicy deliveryPolicy) {
		system.setDeliveryPolicy(deliveryPolicy);
		System.out.println("Delivery policy has been set to " + deliveryPolicy.getClass().getSimpleName());
	}

	public void setProfitPolicy(MyFoodoraSystem system, ProfitPolicy profitPolicy) {
		system.setProfitPolicy(profitPolicy);
		System.out.println("Profit policy has been set to " + profitPolicy.getClass().getSimpleName());
	}

	// Methods to get most/least active courier or restaurant
	public User getMostActiveCourier(List<Courier> couriers) {
		return couriers.stream()
				.max((c1, c2) -> Integer.compare(c1.getDeliveryCount(), c2.getDeliveryCount()))
				.orElse(null);
	}

	public User getLeastActiveCourier(List<Courier> couriers) {
		return couriers.stream()
				.min((c1, c2) -> Integer.compare(c1.getDeliveryCount(), c2.getDeliveryCount()))
				.orElse(null);
	}

	public Restaurant getMostPopularRestaurant(List<Restaurant> restaurants, List<Order> orders) {
		return restaurants.stream()
				.max((r1, r2) -> Integer.compare(
						(int) orders.stream().filter(order -> order.getRestaurant().equals(r1)).count(),
						(int) orders.stream().filter(order -> order.getRestaurant().equals(r2)).count()
				)).orElse(null);
	}

	public Restaurant getLeastPopularRestaurant(List<Restaurant> restaurants, List<Order> orders) {
		return restaurants.stream()
				.min((r1, r2) -> Integer.compare(
						(int) orders.stream().filter(order -> order.getRestaurant().equals(r1)).count(),
						(int) orders.stream().filter(order -> order.getRestaurant().equals(r2)).count()
				)).orElse(null);
	}

	// Methods to set sorting policies for shipped orders
	public void setShippedOrderSortingPolicy(ShippedOrderSortingPolicy policy, List<Order> orders) {
		List<Order> sortedOrders = policy.sortOrders(orders);
		System.out.println("Orders have been sorted using " + policy.getClass().getSimpleName());
		// Optionally print sorted orders or update some system state
	}
}
