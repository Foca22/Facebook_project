package com.project.facebook.model.users;

import com.project.facebook.model.post.Post;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "users")
    private Set<Post> postsSet = new HashSet<>();

    public Users() {
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Users(Integer id, String userName, String password, Set<Post> userPosts) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.postsSet = userPosts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Post> getUserPosts() {
        return postsSet;
    }

    public void setUserPosts(Set<Post> postsSet) {
        this.postsSet = postsSet;
    }
}
