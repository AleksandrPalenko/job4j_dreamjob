package ru.job4j.dreamjob.store;

import org.testng.annotations.Test;
import ru.job4j.dreamjob.MainBoot;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostDBStoreTest {

    @Test
    public void whenCreatePost() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        Post post = new Post(0, "Java Job");
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenFindAllPost() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        store.deleteFrom();
        Post post = new Post(1, "JDBC");
        Post post1 = new Post(2, "Java Core");
        Post post2 = new Post(3, "Spring Boot");
        store.add(post);
        store.add(post1);
        store.add(post2);
        List<Post> posts = List.of(
                new Post(1, "JDBC"),
                new Post(2, "Java Core"),
                new Post(3, "Spring Boot")
        );
        List<Post> postFindAll = store.findAll();
        assertThat(3, is(posts.size()));
        assertThat(postFindAll, equalTo(posts));
    }

    @Test
    public void whenFindAll() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        store.deleteFrom();
        Post post1 = new Post(1, "Middle");
        Post post2 = new Post(2, "Senior");
        store.add(post1);
        store.add(post2);
        List<Post> exp = List.of(new Post(1, "Middle"),
                new Post(2, "Senior"));
        assertThat(store.findAll(), equalTo(exp));
    }

    @Test
    public void whenReplacePost() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        Post post = new Post(1, "JDBC", "middle", LocalDateTime.now(), false, new City(1, "Moscow"));
        store.add(post);
        post.setName("senior");
        store.update(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), equalTo(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        Post post = new Post(1, "Middle");
        store.add(post);
        post.setName("Senior");
        store.update(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), equalTo(post.getName()));
    }

    @Test
    public void whenUpdatePost2() {
        PostDBStore store = new PostDBStore(new MainBoot().loadPool());
        Post post = new Post(0, "Java Job");
        post.setCity(new City(1, null));
        store.add(post);
        post.setName("Python Job");
        store.update(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }
}
