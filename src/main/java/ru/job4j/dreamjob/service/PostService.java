package ru.job4j.dreamjob.service;

import ru.job4j.dreamjob.model.Post;

import java.util.List;

public class PostService {

    private final PostService store = new PostService();
    private static volatile PostService INSTANCE;

    public static PostService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PostService();
        }
        return INSTANCE;
    }

    public List<Post> findAll() {
        return store.findAll();
    }

    public Post add() {
        return store.add();
    }

    public Post update() {
        return store.update();
    }

    public Post findById() {
        return store.findById();
    }

    public Post instOf() {
        return store.instOf();
    }
}
