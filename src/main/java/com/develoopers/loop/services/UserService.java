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

    public Users updateUser(Integer id_user, String first_name, String last_name, String username, String email,String phone,String password, Profile profile) {
       Users user = null;
       if (repository.existsById(id_user)) {
           Users u = repository.findById(id_user).get();
           if (first_name!=null && !first_name.isBlank()) u.setFirst_name(first_name);
           if (last_name!=null && !last_name.isBlank()) u.setLast_name(last_name);
           if (username!=null && !username.isBlank()) u.setUsername(username);
           if (email!=null && !email.isBlank()) u.setEmail(email);
           if (phone!=null && !phone.isBlank()) u.setPhone(phone);
           if (password!=null && !password.isBlank()) u.setPassword(password);
           if (profile.getId_profile() !=null)

           user = u ;
           repository.save(user);
       }//if
        return user;
    }//updateUser

}//UserService
