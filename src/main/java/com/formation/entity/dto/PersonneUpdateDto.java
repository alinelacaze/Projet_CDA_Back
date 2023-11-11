package com.formation.entity.dto;

import com.formation.entity.Colonie;
import com.formation.entity.Role;

public class PersonneUpdateDto {

    private Long id;
    private String firstname;
    private String lastname;
    private Colonie colonie;
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Colonie getColonie() {
        return colonie;
    }

    public void setColonie(Colonie colonie) {
        this.colonie = colonie;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
