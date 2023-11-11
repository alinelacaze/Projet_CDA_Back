package com.formation.controller.rest;

import com.formation.entity.Personne;
import com.formation.entity.dto.AuthRequest;
import com.formation.entity.dto.AuthResponse;
import com.formation.exception.AccountExistsException;
import com.formation.exception.UnauthorizedException;
import com.formation.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/security")
@CrossOrigin("${front.url}")
public class SecurityRestController {

    /** Injecté par le setter. */
    private SecurityService securityService;

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest authRequest) throws UnauthorizedException {
        Authentication authentication;
        try {
            authentication = securityService.authenticate(authRequest.getUsername(), authRequest.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Personne personne = (Personne) authentication.getPrincipal();
            String token = securityService.generateJsonWebTokenForPersonne(personne);
            return ResponseEntity.ok(new AuthResponse(personne, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {
        Personne user = securityService.save(requestDto.getUsername(), requestDto.getPassword(), requestDto.getFirstname(), requestDto.getLastname());
        String token = securityService.generateJsonWebTokenForPersonne(user);
        return ResponseEntity.ok(new AuthResponse(user, token));
    }

    /// Setters ///
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
