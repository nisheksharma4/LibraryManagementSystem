package service;

import model.User;
import java.util.*;

public class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
