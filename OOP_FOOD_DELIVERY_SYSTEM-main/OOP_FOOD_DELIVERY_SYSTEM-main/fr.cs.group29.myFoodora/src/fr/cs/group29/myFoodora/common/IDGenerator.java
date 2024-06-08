package fr.cs.group29.myFoodora.common;

import java.util.UUID;

// Singleton class for ID generation
public class IDGenerator {
    private static IDGenerator instance;

    // Private constructor to prevent instantiation
    private IDGenerator() {}

    // Public method to provide access to the singleton instance
    public static synchronized IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    // Method to generate a unique ID
    public String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
}

