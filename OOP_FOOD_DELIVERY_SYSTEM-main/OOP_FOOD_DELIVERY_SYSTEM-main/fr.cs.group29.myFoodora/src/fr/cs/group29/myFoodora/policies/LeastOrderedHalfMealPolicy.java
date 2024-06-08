package fr.cs.group29.myFoodora.policies;


import fr.cs.group29.myFoodora.common.Meal;
import fr.cs.group29.myFoodora.common.Order;
import fr.cs.group29.myFoodora.policies.ShippedOrderSortingPolicy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// LeastOrderedHalfMealPolicy class implementing ShippedOrderSortingPolicy
public class LeastOrderedHalfMealPolicy implements ShippedOrderSortingPolicy {

    @Override
    public List<Order> sortOrders(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingInt(order -> (int) order.getMeals().stream().filter(Meal::isHalfMeal).count()))
                .collect(Collectors.toList());
    }
}
