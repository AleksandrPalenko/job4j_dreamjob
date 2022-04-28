package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.store.UserDbStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@ThreadSafe
public class UserService {

    private final UserDbStore store;

    private final Map<Integer, User> users = new HashMap<Integer, User>();
    private final AtomicInteger id = new AtomicInteger();

    public UserService(UserDbStore store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return Optional.ofNullable(users.putIfAbsent(id.incrementAndGet(), user));
    }
}
