package com.develoopers.loop.controllers;

import com.develoopers.loop.models.Profile;
import com.develoopers.loop.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/loop/profile/")
public class ProfileController {

    private final ProfileService service;
    @Autowired//Gestiona la inyeccion de dependencias
     public ProfileController(ProfileService service) {
         this.service = service;
     }
    @GetMapping
    public List<Profile> getProfiles() {
        return service.getProfiles();
    }//getProfiles

    @GetMapping("{id_profile}")
    public Profile getProfile(@PathVariable("id_profile") Integer id_profile){
        return service.getProfile(id_profile);
    }//getProfile
     @DeleteMapping("{id_profile}")
    public Profile deleteProfile(@PathVariable("id_profile") Integer id_profile){
        return service.deleteProfile(id_profile);
     }//deleteProfile

    @PostMapping
    public Profile  addProfile(@RequestBody Profile profile){
        return service.addProfile(profile);
    }//addProfile

    @PutMapping("{id_profile}")
    public Profile updateProfile(@PathVariable Integer id_profile, @RequestBody Profile profile){
        return service.updateProfile(id_profile, profile);
    }


}//ProfileController
