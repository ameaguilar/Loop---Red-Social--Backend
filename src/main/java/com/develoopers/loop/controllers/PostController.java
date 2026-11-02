package com.develoopers.loop.controllers;

import com.develoopers.loop.models.Posts;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping(path = "/loop/posts/")
public class PostController {
    private final PostService service;
    @Autowired//Gestiona la inyeccion de dependencias
    public PostController(PostService service) {
        this.service = service;
    }
     @GetMapping
    public List<Posts> getPosts() {
        return service.getPosts();
     }
    @GetMapping("{id_post}")
    public Posts getPosts(@PathVariable Integer id_post) {
        return service.getPost(id_post);
    }//getPosts

    @DeleteMapping("{id_post}")
    public Posts deletePosts(@PathVariable Integer id_post) {
        return service.deletePost(id_post);
    }//deletePosts

    @PostMapping
    public Posts addPost(@RequestBody Posts post) {
        return service.addPost(post);
    }//addPost
    public Posts updatePost(@PathVariable ("id_post") Integer id_post,
                            @RequestParam (required =  false) String resume_description,
                            @RequestParam (required = false) String text,
                            @RequestParam (required = false) String labels,
                            @RequestParam (required = false) Integer likes,
                            @RequestParam (required = false)LocalDateTime date_post,
                            @RequestParam (required =  false) String img_post,
                            @RequestParam (required = false)  String link,
                            @RequestParam (required = false) Users user) {
        return service.updatePost(id_post,resume_description,text,labels,likes,date_post,img_post,link,user);

    }//updatePost

}//PostController
