package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@ThreadSafe
public class PostStore {

    /***
    private static final PostStore INST = new PostStore();
     */

    private final AtomicInteger id = new AtomicInteger();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Collections, Stream API",
                LocalDateTime.now(), true, new City()));
        posts.put(2, new Post(2, "Middle Java Job", "Spring, SQL",
                LocalDateTime.now(), true, new City()));
        posts.put(3, new Post(3, "Senior Java Job", "Docker, Kafka",
                LocalDateTime.now(), true, new City()));
    }

    /**
    public static PostStore instOf() {
        return INST;
    }
     */

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        posts.putIfAbsent(id.incrementAndGet(), post);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

}