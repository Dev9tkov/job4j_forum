package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private UserService userService;
    private int postId = 3;

    public PostService(UserService userService) {
        this.userService = userService;
        User admin = userService.findByName("admin");
        User user = userService.findByName("user");
        Post post1 = new Post(1, "Разработка приложений с использованием SPRING Boot", "Предназначен для Java-программистов, которые планируют использовать SPRING -компоненты в своей практике", admin);
        Post post2 = new Post(2, "Алгоритмы для разработчиков", "Необходим всем, кто прогулял или недостаточно серьёзно относился к занятиям по алгоритмам в вузе", user);
        posts.add(post1);
        posts.add(post2);
    }

    public List<Post> getAll() {
       return posts.stream()
                .sorted(Comparator.comparingInt(Post::getId))
                .collect(Collectors.toList());
    }

    public Post findById(int id) {
        return posts.stream()
                .filter(val -> val.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Post add(Post post) {
        if (post.getId() == 0) {
            post.setId(postId++);
        }
        posts.add(post);
        return post;
    }

    public void updatePost(Post post) {
        Post oldPost = findById(post.getId());
        posts.remove(oldPost);
        add(post);
    }

    public void addAnswer(Post toAnswer, Post post) {
        int answerId = toAnswer.getAnswers().size();
        post.setId(answerId + 1);
        toAnswer.getAnswers().add(post);
    }
}