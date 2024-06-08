package fr.cs.group29.myFoodora.common;

// Abstract Factory class
public abstract class Factory<T> {
    // Abstract method to create objects
    public abstract T create(String type, Object... params);
}

