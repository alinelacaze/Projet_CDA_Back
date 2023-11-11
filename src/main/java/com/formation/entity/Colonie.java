package com.formation.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Colonie extends Catalogue {
    private String name;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String urlImage;
    @Enumerated(EnumType.STRING)
    private Theme theme;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @JsonIgnore
    @OneToMany(mappedBy = "colonie")
    private final List<Personne> personnes = new ArrayList<>();

    public Colonie() {
    }

    public Colonie(String description, LocalDate dateAjout, String name, LocalDate dateDebut, LocalDate dateFin, Theme theme, Availability availability, String urlImage) {
        super(null, description, dateAjout);
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.theme = theme;
        this.availability = availability;
        this.urlImage = urlImage;
    }

    public String getName() { return name; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public Theme getTheme() { return theme; }
    public Availability getAvailability() { return availability; }
    public List<Personne> getPersonnes() { return personnes; }
    public String getUrlImage() { return urlImage; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
