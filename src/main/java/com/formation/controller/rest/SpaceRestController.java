package com.formation.controller.rest;

import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.service.PersonneService;
import com.formation.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/space")
@CrossOrigin(origins = "${front.url}")
public class SpaceRestController {

    SpaceService spaceService;

    @PostMapping("/colonie")
    public Colonie saveColonie(@RequestBody ColonieAddDto colonieAddDto) {
        return spaceService.saveColonie(colonieAddDto);
    }

    @GetMapping("/colonie/{id}/personnes")
    public List<Personne> findColoniePersonnes(@PathVariable long id){
        return spaceService.findColoniePersonnes(id);
    }


    /// Setters ///
    @Autowired
    public void setSpaceService(SpaceService spaceService) {
        this.spaceService = spaceService;
    }
}

