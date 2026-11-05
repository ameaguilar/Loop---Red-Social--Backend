package com.develoopers.loop.models;

import jakarta.persistence.*;
import org.apache.catalina.User;

//POJO - Plain Old Java Object
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_user",nullable = false,unique = true)
    private Integer id_user;

    @Column(name = "first_name" ,nullable = false)
    private String first_name;

    @Column(name = "last_name" ,nullable = false)
    private String last_name;

    @Column(name = "username" , nullable = false, unique = true)
    private String username;

    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @Column(name = "phone" , nullable = false)
    private  String phone;

    @Column(name = "password" , nullable = false)
    private String password;
    @OneToOne
    @JoinColumn(name = "id_profile")
    private  Profile profile ;


    public Users(String first_name, String last_name, String username, String email, String phone, String password , Profile profile) {
        this.first_name = first_name.toUpperCase();
        this.last_name = last_name.toUpperCase();
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profile = profile;
    } // constructor


    public Users() {} //Constructor vacio

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name.toUpperCase();
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name.toUpperCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;

    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }
}//class users
