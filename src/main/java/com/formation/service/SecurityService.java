package com.formation.service;

import com.formation.entity.Personne;
import com.formation.exception.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SecurityService extends UserDetailsService {

    Authentication authenticate(String username, String password) throws AuthenticationException;
    Personne save(String username, String password, String firstname, String lastname) throws AccountExistsException;
    String generateJsonWebTokenForPersonne(Personne personne);
    Personne getPersonneFromJsonWebToken(String token);
}
