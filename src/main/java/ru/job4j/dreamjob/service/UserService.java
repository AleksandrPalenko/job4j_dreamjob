package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.store.UserDbStore;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@ThreadSafe
public class UserService {

    private final UserDbStore store;

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public UserService(UserDbStore store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return store.add(user);
    }

    public Optional<User> findByEmail(String email) {
        return Optional.of(store.findByEmail(email));
    }

    public Optional<User> findUserByEmailAndPwd(String email, String password) {
        Optional<User> rsl = Optional.empty();
        Optional<User> user = findByEmail(email);
        if (user.isPresent()) {
            users.values().stream().filter(s -> s.getPassword().equals(password)).findFirst();
        }
        return rsl;
    }
}
