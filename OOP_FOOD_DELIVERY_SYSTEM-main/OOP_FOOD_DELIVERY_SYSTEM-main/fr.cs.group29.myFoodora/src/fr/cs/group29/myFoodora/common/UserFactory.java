package fr.cs.group29.myFoodora.common;
import fr.cs.group29.myFoodora.users.*;

public class UserFactory extends Factory<User> {

    @Override
    public User create(String type, Object... params) {
        switch (type.toLowerCase()) {
            case "manager":
                return new Manager((String) params[0], (String) params[1], (String) params[2], (String) params[3]);
            case "customer":
                return new Customer((String) params[0], (String) params[1], (String) params[2], (String) params[3],
                        (String) params[4], (String) params[5], (String) params[6]);
            case "courier":
                return new Courier((String) params[0], (String) params[1], (String) params[2], (String) params[3],
                        (String) params[4]);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}


