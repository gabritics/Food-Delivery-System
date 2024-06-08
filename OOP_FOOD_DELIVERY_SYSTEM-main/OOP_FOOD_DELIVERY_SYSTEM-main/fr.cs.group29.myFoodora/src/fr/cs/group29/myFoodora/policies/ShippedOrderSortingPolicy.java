package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.Order;

import java.util.List;

// Interface for ShippedOrderSortingPolicy
public interface ShippedOrderSortingPolicy {
    // Method to sort orders
    List<Order> sortOrders(List<Order> orders);
}
