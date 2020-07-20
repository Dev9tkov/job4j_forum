package ru.job4j.forum.model;

import java.util.*;

public class Post {
    private int id;
    private String name;
    private String desc;
    private Calendar created = new GregorianCalendar();
    private User author;
    private boolean isTopic = false;
    private List<Post> answers = new ArrayList<>();
    private Post topicPost;

    public Post() {
    }

    public Post(String name, String desc, User author) {
        this.name = name;
        this.desc = desc;
        this.author = author;
    }

    public Post(int id, String name, String desc, User author) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.author = author;
    }

    public List<Post> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Post> answers) {
        this.answers = answers;
    }

    public Post getTopicPost() {
        return topicPost;
    }

    public void setTopicPost(Post topicPost) {
        this.topicPost = topicPost;
    }

    public int getId() {
        return id;
    }

    public boolean isTopic() {
        return isTopic;
    }

    public void setTopic(boolean topic) {
        isTopic = topic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
