package fr.cs.group29.myFoodora.common;
import fr.cs.group29.myFoodora.users.*;

import java.util.ArrayList;
import java.util.List;

// NotificationSystem class
public class NotificationSystem {
    // Attributes
    private List<Customer> subscribedCustomers;

    // Constructor
    public NotificationSystem() {
        this.subscribedCustomers = new ArrayList<>();
    }

    // Methods
    public void subscribeCustomer(Customer customer) {
        if (!subscribedCustomers.contains(customer)) {
            subscribedCustomers.add(customer);
            System.out.println(customer.getUsername() + " has subscribed to notifications.");
        }
    }

    public void unsubscribeCustomer(Customer customer) {
        if (subscribedCustomers.contains(customer)) {
            subscribedCustomers.remove(customer);
            System.out.println(customer.getUsername() + " has unsubscribed from notifications.");
        }
    }

    public void sendSpecialOfferNotification(String offerDetails) {
        for (Customer customer : subscribedCustomers) {
            if (customer.hasNotificationsConsent()) {
                System.out.println("Notification sent to " + customer.getUsername() + ": " + offerDetails);
            }
        }
    }
}

