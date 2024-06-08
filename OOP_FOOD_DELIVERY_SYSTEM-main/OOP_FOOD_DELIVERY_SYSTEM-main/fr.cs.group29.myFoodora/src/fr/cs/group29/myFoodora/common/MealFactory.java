package fr.cs.group29.myFoodora.common;

import java.util.List;

// MealFactory class extending Factory
public class MealFactory extends Factory<Meal> {

    @Override
    public Meal create(String type, Object... params) {
        Meal meal = new Meal((String) params[0], (MealType) params[1], (boolean) params[2]);
        if (params.length > 3 && params[3] instanceof List<?>) {
            List<?> dishes = (List<?>) params[3];
            for (Object dish : dishes) {
                if (dish instanceof Dish) {
                    meal.addDish((Dish) dish);
                }
            }
        }
        return meal;
    }
}

