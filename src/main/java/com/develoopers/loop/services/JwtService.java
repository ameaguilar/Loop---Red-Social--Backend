package com.develoopers.loop.services;

import com.develoopers.loop.config.JwtFilter;
import com.develoopers.loop.dtos.LoginRequest;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.UsersRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {

    @Autowired
    PasswordEncoder encoder;

    private final UsersRepository usersRepository;

    public JwtService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    } // constructor

    public boolean validarUsuario(LoginRequest request) {

        // 1. Tengo que verificar que el usuario existe
        // NOTA: Si tu PK es el ID (Long), deberías usar findByEmail(request.getEmail())
        Optional<Users> usuario = usersRepository.findByEmail(request.getEmail());

        if(usuario.isPresent()){
            // 2. Tengo que verificar que la contraseña coincida con la que se guardó en la bd
            Users usr = usuario.get();

            if( encoder.matches( request.getPassword(), usr.getPassword() ) ){
                return true;
            }// if password matches

        }// usuario is present

        return false;
    }// validarUsuario


    /*
     * header:
     * builder(): construye los encabezados del token, ejemplo {"alg": "HS256", "typ": "JWT"}
     *
     * payload:
     * subject(email): indicamos con el correo del usuario a quién pertenece el token
     * claim(): añade una declaración personalizada
     * issuedAt(): claim estándar iat con fecha y hora de creación del token
     * expiration(): claim estándar exp que calcula la fecha de expiración del token
     * signWith(JwtFilter.getSignInKey()): analiza la librería del token para generar los valores anteriores
     *
     * firma:
     * compact(): toma el json del header, payload y la firma secreta. Los concatena en un string codificado en base64
     * */

    public String generarToken(String email) {
        Calendar calendar = Calendar.getInstance(); // new Calendar(): equivalente
        calendar.add(Calendar.HOUR, 3);// Definir la expiración del token

        return Jwts
                .builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(calendar.getTime())
                .signWith(JwtFilter.getSignInKey())
                .compact();
    }// generarToken
} // JwtService