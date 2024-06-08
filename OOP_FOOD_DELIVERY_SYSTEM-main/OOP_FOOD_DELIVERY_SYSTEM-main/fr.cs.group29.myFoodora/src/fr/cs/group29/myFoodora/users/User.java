package fr.cs.group29.myFoodora.users;

import java.util.UUID;

// Abstract User class
public abstract class User {
    // Attributes
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor
    public User(String username, String password, String firstName, String lastName) {
        this.id = UUID.randomUUID().toString(); // Generates a unique ID
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String name, String surname, String username, String email, String phone, String password) {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Methods
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        // Logic for logging out the user can be implemented here
        System.out.println("User " + username + " has logged out.");
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayUserRole();
}