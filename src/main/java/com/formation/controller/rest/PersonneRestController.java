package com.formation.controller.rest;

import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.entity.dto.ColonieUpdateDto;
import com.formation.entity.dto.PersonneUpdateDto;
import com.formation.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personne")
@CrossOrigin(origins = "${front.url}")
public class PersonneRestController {

    PersonneService personneService;

    @PostMapping("/save")
    public ResponseEntity<Personne> savePersonne(@RequestBody Personne personne) {
        return ResponseEntity.ok().body(personneService.savePersonne(personne));
    }

    @PutMapping("/update/{id}")
    public Personne updatePersonne(@PathVariable long id, @RequestBody PersonneUpdateDto personneUpdateDto) {
        return personneService.updatePersonne(personneUpdateDto);
    }


    @GetMapping("/{id}")
    public Personne findPersonne(@PathVariable long id) {
        return personneService.findPersonne(id);
    }

    @Autowired
    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }
}
