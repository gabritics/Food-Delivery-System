package fr.cs.group29.myFoodora.policies;

import fr.cs.group29.myFoodora.common.MyFoodoraSystem;

// Abstract ProfitPolicy class extending Policy
public abstract class ProfitPolicy extends Policy {
    // Abstract method to be implemented by subclasses
    public abstract void calculateParameters(MyFoodoraSystem system);
}

