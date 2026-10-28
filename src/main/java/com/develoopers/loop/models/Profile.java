package com.develoopers.loop.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//POJO - Plain Old Java Object
@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profile;

    @Column(name = "img_profile" ,nullable = true)
    private  String img_profile;

    @Column(name = "biography" ,nullable = false)
    private String biography;

    @Column(name = "occupation" ,nullable = false)
    private String occupation;

    @Column(name = "skills" ,nullable = false)
    private String skills ;

    @Column(name = "create_date" ,nullable = false)
    private LocalDateTime create_date;

    public Profile(String img_profile, String biography, String occupation, String skills, LocalDateTime create_date) {
        this.img_profile = img_profile;
        this.biography = biography;
        this.occupation = occupation.toUpperCase();
        this.skills = skills;
        this.create_date = create_date;
    }
     public Profile() {} // constructor vacio para la instacia

    public Integer getId_profile() {
        return id_profile;
    }//

    public void setId_profile(Integer id_profile) {
        this.id_profile = id_profile;
    }//

    public String getImg_profile() {
        return img_profile;
    }//

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }//

    public String getBiography() {
        return biography;
    }//

    public void setBiography(String biography) {
        this.biography = biography;
    }//

    public String getOccupation() {
        return occupation;
    }//

    public void setOccupation(String occupation) {
        this.occupation = occupation.toUpperCase();
    }//

    public String getSkills() {
        return skills;
    }//

    public void setSkills(String skills) {
        this.skills = skills;
    }//

    public LocalDateTime getCreate_date() {
        return create_date;
    }//

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }//

    @Override
    public String toString() {
        return "Profile{" +
                "id_profile=" + id_profile +
                ", img_profile='" + img_profile + '\'' +
                ", biography='" + biography + '\'' +
                ", occupation='" + occupation + '\'' +
                ", skills='" + skills + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}// class profile
