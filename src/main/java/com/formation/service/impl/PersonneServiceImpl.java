package com.formation.service.impl;

import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieUpdateDto;
import com.formation.entity.dto.PersonneUpdateDto;
import com.formation.repository.ColonieDao;
import com.formation.repository.PersonneDao;
import com.formation.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService {

    PersonneDao personneDao;


    @Override
    public Personne savePersonne(Personne personne) {
        personneDao.save(personne);
        return personne;
    }

    @Override
    public Personne updatePersonne(PersonneUpdateDto personneUpdateDto) {
        Personne updatedPersonne = findPersonne(personneUpdateDto.getId());
        updatedPersonne.setColonie(personneUpdateDto.getColonie());
        personneDao.save(updatedPersonne);
        return updatedPersonne;
    }

    @Override
    public Personne findPersonne(long id) {
        return personneDao.findById(id);
    }

    @Autowired
    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }
}
