package com.generation.ecommerce.dtos;

public class PasswordDto {
    private String passwordActual;
    private String passwordNuevo;

    public PasswordDto(String passwordActual, String passwordNuevo) {
        this.passwordActual = passwordActual;
        this.passwordNuevo = passwordNuevo;
    }// constructor

    public PasswordDto() {}// constructor vacio

    public String getPasswordActual() {
        return passwordActual;
    }

    public String getPasswordNuevo() {
        return passwordNuevo;
    }

}


