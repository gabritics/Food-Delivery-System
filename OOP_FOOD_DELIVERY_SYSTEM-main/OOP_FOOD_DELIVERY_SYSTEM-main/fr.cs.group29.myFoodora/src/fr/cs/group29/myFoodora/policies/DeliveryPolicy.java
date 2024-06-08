package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.Order;
import fr.cs.group29.myFoodora.policies.Policy;

// Abstract DeliveryPolicy class extending Policy
public abstract class DeliveryPolicy extends Policy {
    // Abstract method to be implemented by subclasses
    public abstract void assignCourier(Order order);
}
