package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.*;
import fr.cs.group29.myFoodora.users.*;
import fr.cs.group29.myFoodora.policies.ShippedOrderSortingPolicy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MostOrderedItemALaCartePolicy implements ShippedOrderSortingPolicy {

    @Override
    public List<Order> sortOrders(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingInt(order -> Order.getItems().size()).reversed())
                .collect(Collectors.toList());
    }
}
