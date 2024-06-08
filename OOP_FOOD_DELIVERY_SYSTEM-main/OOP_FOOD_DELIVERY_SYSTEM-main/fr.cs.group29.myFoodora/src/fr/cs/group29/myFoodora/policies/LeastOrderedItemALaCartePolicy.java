package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.Order;
import fr.cs.group29.myFoodora.policies.ShippedOrderSortingPolicy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// LeastOrderedItemALaCartePolicy class implementing ShippedOrderSortingPolicy
public class LeastOrderedItemALaCartePolicy implements ShippedOrderSortingPolicy {

    @Override
    public List<Order> sortOrders(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingInt(order -> order.getItems().size()))
                .collect(Collectors.toList());
    }
}

