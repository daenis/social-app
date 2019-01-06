package com.example.post;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post implements Serializable {

    private static final long serialVersionUID = 7548395543L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private Integer postId;

    @Column(name = "TEXT")
    private String text;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        comment.setPost(null);
        this.comments.remove(comment);
    }

}
