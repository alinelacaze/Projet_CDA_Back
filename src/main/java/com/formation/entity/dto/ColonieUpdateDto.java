package com.formation.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formation.entity.Availability;
import com.formation.entity.Theme;

import java.time.LocalDate;
import java.util.Date;

public class ColonieUpdateDto {

    private Long id;
    private String name;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Theme theme;
    private Availability availability;
    private String urlImage;

    public Long getId(){return id;}

    public String getName(){ return name; }
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Theme getTheme() {
        return theme;
    }

    public Availability getAvailability() {
        return availability;
    }
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
    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }
}

