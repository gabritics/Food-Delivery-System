package fr.cs.group29.myFoodora.common;

// DishFactory class extending Factory
public class DishFactory extends Factory<Dish> {

    @Override
    public Dish create(String type, Object... params) {
        return new Dish((String) params[0], (DishCategory) params[1], (DishType) params[2], (double) params[3]);
    }
}

