package com.develoopers.loop.services;

import com.develoopers.loop.models.Posts;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PostService {
    private final PostsRepository repository;
    public PostService(PostsRepository repository) {
        this.repository = repository;
    }
    public List<Posts> getPosts() {
        return repository.findAll();
    }//getPosts
    public Posts getPost(Integer id_post) {
        return repository .findById(id_post)
                .orElseThrow(() -> new IllegalArgumentException("La publicacion  con el id [" + id_post + "] no existe."));
    }//getPost
     public Posts deletePost(Integer id_post) {
         Posts post = null;
         if (repository.existsById(id_post)) {
             post = repository.findById(id_post).get();
             repository.delete(post);
         }//If
         return post;
     }//deleteUser
    public Posts addPost(Posts post) {
        if(!post.getResume_description().isBlank() && !post.getText().isBlank()
                && post.getResume_description() != null &&  post.getText() != null) {
            repository.save(post);

        }//
        return post;
    }//addUser
    public Posts updatePost(Integer id_post, String resume_description, String text, String labels, Integer likes, LocalDateTime date_post,String img_post,String link, Users user) {
        Posts post = null;
        if (repository.existsById(id_post)) {
            Posts p = repository.findById(id_post).get();
            if (resume_description != null && !resume_description.isBlank())
                p.setResume_description(resume_description);
            if (text != null && !text.isBlank()) p.setText(text);
            if (labels != null && !labels.isBlank()) p.setLabels(labels);
            if (likes != null) p.setLikes(likes);
            if (date_post != null) p.setDate_post(date_post);
            if (img_post != null) p.setImg_post(img_post);
            if (link != null) p.setLink(link);
            post = p;
            repository.save(p);

        }//if
        return post;
    }


}//PostService
