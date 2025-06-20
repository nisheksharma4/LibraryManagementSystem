package model;

public class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Overloaded constructor with email
    public User(String id, String name, String email) {
        this(id, name);
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional: toString() for debugging/logging
    @Override
    public String toString() {
        return "User{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
