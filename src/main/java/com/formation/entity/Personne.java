package com.formation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "personne")
public class Personne implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstname;
    private String lastname;

    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name="colonie_id")
    private Colonie colonie;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Personne() {
    }

    public Personne(Long id, String firstname, String lastname, Colonie colonie, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.colonie = colonie;
        this.role = role;
    }

    public Personne(String firstname, String lastname, Colonie colonie, Role role) {
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Colonie getColonie() {
        return colonie;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setColonie(Colonie colonie) {
        this.colonie = colonie;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    /// Setters ///
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
