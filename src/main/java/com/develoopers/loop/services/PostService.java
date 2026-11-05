package com.develoopers.loop.services;

import com.develoopers.loop.models.Posts;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.awt.SystemColor.text;

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
    public Posts updatePost(Integer id_post, Posts posts, Users users) {
        Posts post = null;

        if (repository.existsById(id_post)) {
            Posts p = repository.findById(id_post).get();

            // 1. Usamos los getters para obtener los valores del objeto 'posts'
            if (posts.getResume_description() != null && !posts.getResume_description().isBlank()) {
                p.setResume_description(posts.getResume_description());
            }

            // 2. Corregido: Usar posts.getText() en lugar de solo 'text' o 'posts.text'
            if (posts.getText() != null && !posts.getText().isBlank()) {
                p.setText(posts.getText());
            }

            // 3. Corregido: Traer los valores desde el objeto 'posts'
            if (posts.getLabels() != null && !posts.getLabels().isBlank()) {
                p.setLabels(posts.getLabels());
            }

            if (posts.getLikes() != null) {
                p.setLikes(posts.getLikes());
            }

            if (posts.getDate_post() != null) {
                p.setDate_post(posts.getDate_post());
            }

            if (posts.getImg_post() != null) {
                p.setImg_post(posts.getImg_post());
            }

            if (posts.getLink() != null) {
                p.setLink(posts.getLink());
            }

            // NOTA: Tienes un parámetro 'Users users' que no estás usando.
            // Si el post debe registrar quién lo modificó, podrías agregar:
            // if (users != null) { p.setUsers(users); }

            post = p;
            repository.save(p);

        } //if

        return post;
    }


}//PostService
