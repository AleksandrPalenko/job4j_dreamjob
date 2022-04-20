package ru.job4j.dreamjob.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStore {

    /***
    private static final PostStore INST = new PostStore();
     */

    private final AtomicInteger id = new AtomicInteger();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Collections, Stream API"));
        posts.put(2, new Post(2, "Middle Java Job", "Spring, SQL"));
        posts.put(3, new Post(3, "Senior Java Job", "Docker, Kafka"));
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