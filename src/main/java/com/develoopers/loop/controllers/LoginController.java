package com.develoopers.loop.controllers;

import com.develoopers.loop.dtos.LoginRequest;
import com.develoopers.loop.dtos.TokenJwt;
import com.develoopers.loop.services.JwtService;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/loop/login")
public class LoginController {
    private  final JwtService service;

    @Autowired
    public LoginController(JwtService service){
        this.service = service;
    } // constructor

    @PostMapping
    public TokenJwt validarUsuario(@RequestBody LoginRequest request) throws ServletException{

        if( service.validarUsuario(request) ){
            return new TokenJwt( service.generarToken( request.getEmail() ) );
        }// if usuario es válido

        throw new ServletException("> Error de login: correo o contraseña incorrectos.");

    }// validarUsuario
} // class LoginController
