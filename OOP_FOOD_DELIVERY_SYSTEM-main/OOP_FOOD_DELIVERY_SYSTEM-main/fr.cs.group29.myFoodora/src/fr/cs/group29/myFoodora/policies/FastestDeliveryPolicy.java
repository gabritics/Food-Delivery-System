package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.Order;
import fr.cs.group29.myFoodora.common.MyFoodoraSystem;
import fr.cs.group29.myFoodora.users.*;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// FastestDeliveryPolicy class extending DeliveryPolicy
public class FastestDeliveryPolicy extends DeliveryPolicy {

    @Override
    public void applyPolicy() {
        // This method might contain logic to configure the policy, if needed
        System.out.println("Applying Fastest Delivery Policy.");
    }

    @Override
    public void assignCourier(Order order) {
        // Find the nearest available courier based on current position and restaurant location
        List<Courier> couriers = MyFoodoraSystem.getInstance().getCouriers();
        Optional<Courier> nearestCourier = couriers.stream()
                .filter(Courier::isOnDuty)
                .min(Comparator.comparing(courier -> calculateDistance(courier.getCurrentPosition(), order.getRestaurant().getLocation())));

        if (nearestCourier.isPresent()) {
            order.setCourier(nearestCourier.get());
            System.out.println("Courier " + nearestCourier.get().getUsername() + " assigned to order " + order.getId() + " based on the fastest delivery policy.");
        } else {
            System.out.println("No available couriers to assign for order " + order.getId());
        }
    }

    private double calculateDistance(String courierPosition, String restaurantLocation) {
        // Placeholder for actual distance calculation logic
        return Math.random() * 10; // This is just a placeholder for simplicity
    }
}

