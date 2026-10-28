package com.develoopers.loop.controllers;

import com.develoopers.loop.models.Profile;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.ProfileRepository;
import com.develoopers.loop.repositories.UsersRepository;
import com.develoopers.loop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/loop/users/")
public class UsersController {
    private final UserService service;


    @Autowired//Gestiona la inyeccion de dependencias
    public UsersController(UserService service) {
        this.service = service;
    }//Constructor

    @GetMapping
    public List<Users> getUsers() {
        return service.getUsers();
    }//getUsers

    @GetMapping("{id_user}")
    public Users getUser(@PathVariable("id_user") Integer id_user){
        return service.getUser(id_user);
    }//getProducto

    @DeleteMapping("{id_user}")
    public Users deleteUser(@PathVariable("id_user") Integer id_user){
       return service.deleteUser(id_user);
    }//deleteUSer

    @PostMapping
    public Users addUser(@RequestBody Users user){ // Solicita los datos del producto en el cuerpo de la solicitud
        return service.addUser(user);
    }//addUser

    @PutMapping("{id_user}")
    public Users updateUser(@PathVariable("id_user") Integer id_user,
                            @RequestParam(required = false) String username,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) String phone,
                            @RequestParam(required = false) String password,
                            @RequestParam(required = false) Profile profile ){
        return service.updateUser(id_user,username,email,phone,password,profile);// Solicita los datos que actualizaremos en la URL de la solicitud

    }//updateUser





}// Class UserController
