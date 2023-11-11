package com.formation.service;

import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;

import java.util.List;

public interface SpaceService {

    Colonie saveColonie(ColonieAddDto colonieAddDto);

    List<Personne> findColoniePersonnes(long id);
}
