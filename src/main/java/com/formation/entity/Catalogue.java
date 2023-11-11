package com.formation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String description;
    private LocalDate dateAjout;

    public Catalogue() {
    }

    public Catalogue(Long id, String description, LocalDate dateAjout) {
        this.id = id;
        this.description = description;
        this.dateAjout = dateAjout;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }
}
