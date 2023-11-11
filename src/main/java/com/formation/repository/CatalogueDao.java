package com.formation.repository;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogueDao extends JpaRepository<Catalogue, Long> {

    @Query("SELECT c FROM Catalogue c")
    List<Catalogue> displayCatalogue();


}
