package com.develoopers.loop.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
//POJO - Plain Old Java Object
@Entity
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_comment")
    private Integer id_comment;

    @Column(name = "date_comment" ,nullable = false)
    private LocalDateTime date_comment;

    @Column(name = "text_comment" ,nullable = false)
    private String text_comment;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Posts post;

    public Comments(LocalDateTime date_comment, String text_comment, Users user, Posts post) {
        this.date_comment = date_comment;
        this.text_comment = text_comment;
        this.user = user;
        this.post = post;
    }
    public Comments() {} // Constructor vacio

    public Integer getId_comment() {
        return id_comment;
    }

    public void setId_comment(Integer id_comment) {
        this.id_comment = id_comment;
    }

    public LocalDateTime getDate_comment() {
        return date_comment;
    }

    public void setDate_comment(LocalDateTime date_comment) {
        this.date_comment = date_comment;
    }

    public String getText_comment() {
        return text_comment;
    }

    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id_comment=" + id_comment +
                ", date_comment=" + date_comment +
                ", text_comment='" + text_comment + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}// class Comments
