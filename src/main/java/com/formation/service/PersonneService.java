package com.formation.service;


import com.formation.entity.Personne;
import com.formation.entity.dto.PersonneUpdateDto;

import java.util.List;


public interface PersonneService {

    Personne savePersonne(Personne personne);

    Personne updatePersonne(PersonneUpdateDto personneUpdateDto);

    Personne findPersonne(long id);


}
