package com.develoopers.loop.services;
import com.develoopers.loop.models.Profile;
import com.develoopers.loop.repositories.ProfileRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
@Service
public class ProfileService {

    private final ProfileRepository repository;


    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }//Constructor

    public List<Profile> getProfiles() {
        return repository.findAll();
    }//getProfiles
    public Profile getProfile(Integer id_profile) {
        return repository
                .findById(id_profile)
                .orElseThrow(() -> new IllegalArgumentException("El Usuario con el id [" + id_profile + "] no existe."));
    }//getprofile

    public Profile deleteProfile(Integer id_profile) {
        Profile profile = null;
        if (repository.existsById(id_profile)) {
            profile = repository.findById(id_profile).get();
            repository.delete(profile);
        }//If
        return profile;
    }// deleteProfile

    public Profile addProfile( Profile profile) {
        if(!profile.getBiography().isBlank() && !profile.getOccupation().isBlank()
                && profile.getBiography()!= null &&  profile.getOccupation() != null) {
            repository.save(profile);

        }//
        return profile;
    }

    public Profile updateProfile(Integer id_profile, Profile profile ) {
        Profile pro = null;
        if (repository.existsById(id_profile)) {
         Profile p = repository.findById(id_profile).get();
         if(profile.getImg_profile()!=null && !profile.getImg_profile().isBlank())p.setImg_profile(profile.getImg_profile());
         if(profile.getBiography()!=null && !profile.getBiography().isEmpty()) p.setBiography(profile.getBiography());
         if(profile.getOccupation()!=null && !profile.getOccupation().isEmpty()) p.setOccupation(profile.getOccupation());
         if(profile.getSkills()!=null && !profile.getSkills().isBlank()) p.setSkills(profile.getSkills());
         if(profile.getCreate_date()!=null) p.setCreate_date(profile.getCreate_date());
         profile = p ;
         repository.save(profile);
        }// if
        return profile;
    }//updateprofile
}//ProfileService
