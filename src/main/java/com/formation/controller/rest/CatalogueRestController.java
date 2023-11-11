package com.formation.controller.rest;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue")
@CrossOrigin(origins = "${front.url}")
public class CatalogueRestController {

    CatalogueService catalogueService;

    @GetMapping("/colonies")
    public List<Catalogue> displayCatalogue() {
        return catalogueService.displayCatalogue();
    }



    @Autowired
    public void setCatalogueService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }
}
