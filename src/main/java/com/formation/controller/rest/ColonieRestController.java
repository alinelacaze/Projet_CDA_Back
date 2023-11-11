package com.formation.controller.rest;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.entity.dto.ColonieDeleteDto;
import com.formation.entity.dto.ColonieUpdateDto;
import com.formation.repository.ColonieDao;
import com.formation.service.ColonieService;
import com.formation.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colonie")
@CrossOrigin(origins = "${front.url}")
public class ColonieRestController {

    ColonieService colonieService;

    SpaceService spaceService;
    ColonieDao colonieDao;

    @ResponseBody
    @GetMapping("/{id}")
    public Colonie findColonie(@PathVariable long id) {
        return colonieService.findColonie(id);
    }

    @GetMapping("/display")
    public List<Colonie> displayColonie() { return colonieService.displayColonie(); }

    @GetMapping("/spring")
    public List<Colonie> displaySpringColonie() { return colonieService.displaySpringColonie(); }

    @GetMapping("/summer")
    public List<Colonie> displaySummerColonie() { return colonieService.displaySummerColonie(); }

    @GetMapping("/fall")
    public List<Colonie> displayFallColonie() { return colonieService.displayFallColonie(); }

    @GetMapping("/winter")
    public List<Colonie> displayWinterColonie() { return colonieService.displayWinterColonie(); }

    @GetMapping("/finished")
    public List<Colonie> displayFinishedColonie() { return colonieService.displayFinishedColonie(); }

    @PutMapping("/update/{id}")
    public Colonie updateColonie(@PathVariable long id, @RequestBody ColonieUpdateDto colonieUpdateDto) { return colonieService.updateColonie(colonieUpdateDto); }

    @DeleteMapping("/delete/{id}")
    public void deleteColonie(@PathVariable long id) { colonieService.deleteColonie(id); }

    @GetMapping("/toDelete")
    public List<Colonie> displayToDeleteColonie() { return colonieService.displayToDeleteColonie(); }


    @Autowired
    public void setColonieService(ColonieService colonieService) {
        this.colonieService = colonieService;
    }
}
