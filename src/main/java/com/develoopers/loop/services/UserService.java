package com.develoopers.loop.services;

import com.develoopers.loop.models.Profile;
import com.develoopers.loop.models.Users;
import com.develoopers.loop.repositories.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository repository;
    public UserService(UsersRepository repository) {
        this.repository = repository;
    } // constructor

    public List<Users> getUsers() {
        return repository.findAll();//SELECT * FROM Users nombre de la tabla
    }//getUsers

    public Users getUser(Integer id_user) {
        return repository
                .findById(id_user)
                .orElseThrow(() -> new IllegalArgumentException("El Usuario con el id [" + id_user + "] no existe."));
    }//getUser

    public Users deleteUser(Integer id_user) {
        Users user = null;
        if (repository.existsById(id_user)) {
            user = repository.findById(id_user).get();
            repository.delete(user);
        }//If
        return user;
    }//deleteUser
     public Users addUser(Users user) {
        if(!user.getFirst_name().isBlank() && !user.getLast_name().isBlank()
                && user.getFirst_name() != null &&  user.getLast_name() != null) {
                 repository.save(user);

        }//
        return user;
     }//addUser

    public Users updateUser(Integer id_user, Users users) {
       Users user = null;
       if (repository.existsById(id_user)) {
           Users u = repository.findById(id_user).get();
           if (users.getFirst_name()!=null && !users.getFirst_name().isBlank()) u.setFirst_name(users.getFirst_name());
           if (users.getLast_name()!=null && !users.getLast_name().isBlank()) u.setLast_name(users.getLast_name());
           if (users.getUsername()!=null && !users.getUsername().isBlank()) u.setUsername(users.getUsername());
           if (users.getEmail()!=null && !users.getEmail().isBlank()) u.setEmail(users.getEmail());
           if (users.getPhone()!=null && !users.getPhone().isBlank()) u.setPhone(users.getPhone());
           if (users.getPassword()!=null && !users.getPassword().isBlank()) u.setPassword(users.getPassword());

           user = u ;
           repository.save(user);
       }//if
        return user;
    }//updateUser

}//UserService
