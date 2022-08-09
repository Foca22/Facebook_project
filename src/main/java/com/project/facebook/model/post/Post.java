package com.project.facebook.model.post;

import com.project.facebook.model.users.Users;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    public Post() {
    }

    public Post(String text, Users users) {
        this.text = text;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
