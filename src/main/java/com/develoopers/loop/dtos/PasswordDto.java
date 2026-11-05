package com.develoopers.loop.dtos;

public class PasswordDto {
    private String passwordActual;
    private String passwordNuevo;

    public PasswordDto(String passwordActual, String passwordNuevo) {
        this.passwordActual = passwordActual;
        this.passwordNuevo = passwordNuevo;
    } // costructor

    public PasswordDto (){ } // constructor vacio

    public String getPasswordActual() {
        return passwordActual;
    } // getPasswordActual


    public String getPasswordNuevo() {
        return passwordNuevo;
    } // getPasswordNuevo

} // class PasswordDto