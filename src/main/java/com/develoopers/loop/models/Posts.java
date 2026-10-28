package com.develoopers.loop.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//POJO - Plain Old Java Object
@Entity
@Table(name="posts")
public class Posts {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_posts")
    private Integer id_posts;

    @Column(name = "resume_description" ,nullable = false)
    private String resume_description;

    @Column(name = "text" ,nullable = false)
    private String text;

    @Column(name = "labels" ,nullable = false)
    private  String labels;

    @Column(name = "likes" ,nullable = true)
    private Integer  likes;

    @Column(name = "date_post" ,nullable = false)
    private LocalDateTime date_post;

    @Column(name = "img_post" ,nullable = true)
    private String img_post;

    @Column(name = "link" ,nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    public Posts(String resume_description, String text, String labels, Integer likes, LocalDateTime date_post, String img_post, String link ,Users user) {
        this.resume_description = resume_description;
        this.text = text;
        this.labels = labels;
        this.likes = likes;
        this.date_post = date_post;
        this.img_post = img_post;
        this.link = link;
        this.user = user;
    }// Constructor
    public Posts() {}//contructor vacio

    public Integer getId_posts() {
        return id_posts;
    }

    public void setId_posts(Integer id_posts) {
        this.id_posts = id_posts;
    }

    public String getResume_description() {
        return resume_description;
    }

    public void setResume_description(String resume_description) {
        this.resume_description = resume_description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public LocalDateTime getDate_post() {
        return date_post;
    }

    public void setDate_post(LocalDateTime date_post) {
        this.date_post = date_post;
    }

    public String getImg_post() {
        return img_post;
    }

    public void setImg_post(String img_post) {
        this.img_post = img_post;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id_posts=" + id_posts +
                ", resume_description='" + resume_description + '\'' +
                ", text='" + text + '\'' +
                ", labels='" + labels + '\'' +
                ", likes=" + likes +
                ", date_post=" + date_post +
                ", img_post='" + img_post + '\'' +
                ", link='" + link + '\'' +
                ", user=" + user +
                '}';
    }
}// Post
