package com.formation.service.impl;

import com.formation.entity.Personne;
import com.formation.exception.AccountExistsException;
import com.formation.repository.PersonneDao;
import com.formation.service.SecurityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Configuration
public class SecurityServiceImpl implements SecurityService {

    private PersonneDao personneDao;
    private AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final String signingKey;

    public SecurityServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne personne = personneDao.findByLogin(username);
        if (personne == null) {
            throw new UsernameNotFoundException("The user could not be found");
        }
        return personne;
    }

    // Used for registration
    public Personne save(String username, String password, String firstname, String lastname) throws AccountExistsException {
        if (personneDao.findByLogin(username) != null) {
            throw new AccountExistsException();
        }
        Personne personne = new Personne();
        personne.setLogin(username);
        personne.setPassword(passwordEncoder().encode(password));
        personne.setFirstname(firstname);
        personne.setLastname(lastname);
        personneDao.save(personne);
        return personne;
    }

    // Used for authentication
    public Personne getPersonneFromJsonWebToken(String token) {
        String username = getUsernameFromToken(token);
        return (Personne) loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        System.out.println(signingKey);
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String generateJsonWebTokenForPersonne(Personne personne) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(personne.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();
    }

    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    /// Setters ///
    @Autowired
    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
