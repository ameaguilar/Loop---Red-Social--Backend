package com.develoopers.loop.services;

import com.develoopers.loop.models.Comments;
import com.develoopers.loop.models.Posts;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentsRepository repository;


    public CommentService(CommentsRepository repository) {
        this.repository = repository;
    }//Constructor
     public List<Comments> getComment() {
        return repository.findAll();
     }//getComment

    public Comments getComment(Integer id_comment) {
        return repository
                .findById(id_comment)
                .orElseThrow(() -> new IllegalArgumentException("El comentario con el id [" + id_comment + "] no existe."));
    }//getComment
    public Comments deleteComment(Integer id_comment) {
        Comments comment = null;
        if (repository.existsById(id_comment)) {
            comment = repository.findById(id_comment).get();
            repository.delete(comment);
        }//If
        return comment;
    }//deleteComment

    public Comments addComment(Comments comment) {
        if(!comment.getText_comment().isBlank()
                && comment.getText_comment() != null ) {
            repository.save(comment);

        }//
        return comment;
    }//addComments
    public Comments updateComment(Integer id_comment, Comments comment) {
        Comments com = null;
        if(repository.existsById(id_comment)){
            Comments c = repository.findById(id_comment).get();

            if(comment.getText_comment() != null);


            com = c;
            repository.save(com);
        }// if
        return comment;
    } // updateComment


}
