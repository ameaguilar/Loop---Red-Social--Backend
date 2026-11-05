package com.generation.ecommerce.dtos;

public class TokenJwt {

    private String token;
    public TokenJwt(String token) {
        this.token = token;
    }// constructor

    public void TokenJwt() {};

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "TokenJwt{" + "token=" + token + '}';
    }

}
