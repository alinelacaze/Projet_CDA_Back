package com.formation.repository;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColonieDao extends JpaRepository<Colonie, Long> {

    Colonie findById(long id);

    @Query("SELECT a FROM Colonie a")
    List<Colonie> displayAllColonie();

    @Query("SELECT a FROM Colonie a WHERE availability = 'DISPONIBLE'")
    List<Colonie> displayColonie();

    @Query("SELECT a FROM Colonie a WHERE theme = 'PRINTEMPS'")
    List<Colonie> displaySpringColonie();

    @Query("SELECT a FROM Colonie a WHERE theme = 'ETE'")
    List<Colonie> displaySummerColonie();

    @Query("SELECT a FROM Colonie a WHERE theme = 'AUTOMNE'")
    List<Colonie> displayFallColonie();

    @Query("SELECT a FROM Colonie a WHERE theme = 'HIVER'")
    List<Colonie> displayWinterColonie();

    @Query("SELECT a FROM Colonie a WHERE a.availability = 'TERMINE'")
    List<Colonie> displayFinishedColonie();

    @Query("SELECT distinct a from Colonie a left join Personne b on a.id = b.colonie where b.colonie is null")
    List<Colonie> displayToDeleteColonie();
}
