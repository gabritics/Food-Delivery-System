package fr.cs.group29.myFoodora.policies;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import fr.cs.group29.myFoodora.common.Order;
import fr.cs.group29.myFoodora.common.MyFoodoraSystem;
import fr.cs.group29.myFoodora.users.*;

// FairOccupationDeliveryPolicy class extending DeliveryPolicy
public class FairOccupationDeliveryPolicy extends DeliveryPolicy {

    @Override
    public void applyPolicy() {
        // This method might contain logic to configure the policy, if needed
        System.out.println("Applying Fair Occupation Delivery Policy.");
    }

    @Override
    public void assignCourier(Order order) {
        // Find the courier with the fewest deliveries
        List<Courier> couriers = MyFoodoraSystem.getInstance().getCouriers();
        Optional<Courier> leastBusyCourier = couriers.stream()
                .filter(Courier::isOnDuty)
                .min(Comparator.comparing(Courier::getDeliveryCount));

        if (leastBusyCourier.isPresent()) {
            order.setCourier(leastBusyCourier.get());
            System.out.println("Courier " + leastBusyCourier.get().getUsername() + " assigned to order " + order.getId() + " based on the fair occupation policy.");
        } else {
            System.out.println("No available couriers to assign for order " + order.getId());
        }
    }
}

