package com.example.post;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

    private static final long serialVersionUID = 432789457849L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Integer commentId;

    @Column(name = "TEXT")
    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
