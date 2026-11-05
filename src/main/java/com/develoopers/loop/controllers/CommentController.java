package com.develoopers.loop.controllers;


import com.develoopers.loop.models.Comments;
import com.develoopers.loop.models.Posts;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/loop/comments/")
public class CommentController {
    private final CommentService service;
    @Autowired//Gestiona la inyeccion de dependencias
    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comments> getComment() {
        return service.getComment();
    }//getComment

    @GetMapping("{id_comment}")
    public Comments  getComment(@PathVariable("id_comment")Integer id_comment) {
        return service.getComment(id_comment);
    }//getComment
    @DeleteMapping("id_comment")
    public Comments deleteComment(@PathVariable("id_comment")Integer id_comment) {
        return service.deleteComment(id_comment);
    }//deleteComment

    @PostMapping
    public Comments addComment(@RequestBody Comments comment) {
        return service.addComment(comment);
    }//addComment

    @PutMapping("{id_comment}")
    public Comments updateComment(@PathVariable Integer id_comment, @RequestBody Comments comment) {
        return service.updateComment(id_comment, comment);
    }//updateComment

}//CommentController
