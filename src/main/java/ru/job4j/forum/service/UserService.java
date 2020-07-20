package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    int userId = 3;

    public UserService() {
        users.add(new User(1, "user", "qwer"));
        users.add(new User(2, "admin", "root"));
    }

    public void add(User user) {
        user.setId(userId++);
        users.add(user);
    }

    public User findByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean isLoginFree(String login) {
        return users.stream()
                .noneMatch(val->val.getName().equals(login));
    }

    public boolean isExist(User user) {
        boolean rsl = false;
        User userByName = findByName(user.getName());
        if (userByName != null && userByName.getPassword().equals(user.getPassword())) {
            rsl = true;
        }
        return rsl;
    }
}
