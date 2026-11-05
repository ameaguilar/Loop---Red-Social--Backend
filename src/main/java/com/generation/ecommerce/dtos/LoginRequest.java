package com.generation.ecommerce.dtos;
public class LoginRequest {
    private String identifier;
    private String password;
    public LoginRequest() {}
    public String getIdentifier() { return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
