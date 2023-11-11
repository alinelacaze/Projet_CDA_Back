package com.formation.entity.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {

    private UserDetails personne;
    private String token;

    public AuthResponse(UserDetails personne, String token) {
        this.personne = personne;
        this.token = token;
    }

    public UserDetails getPersonne() {
        return personne;
    }
    public String getToken() {
        return token;
    }
}

