package com.formation.service;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.entity.dto.ColonieDeleteDto;
import com.formation.entity.dto.ColonieUpdateDto;

import java.util.List;

public interface ColonieService {

    Colonie findColonie(long id);

    List<Colonie> displayColonie();

    List<Colonie> displaySpringColonie();
    List<Colonie> displaySummerColonie();
    List<Colonie> displayFallColonie();
    List<Colonie> displayWinterColonie();

    List<Colonie> displayAllColonie();

    List<Colonie> displayFinishedColonie();

    Colonie updateColonie(ColonieUpdateDto colonieUpdateDto);

    void deleteColonie(long id);

    List<Colonie> displayToDeleteColonie();
}
