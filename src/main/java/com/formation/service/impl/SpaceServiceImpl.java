package com.formation.service.impl;

import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.repository.ColonieDao;
import com.formation.repository.PersonneDao;
import com.formation.service.SecurityService;
import com.formation.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {

    /** Injecté par le setter. */
    ColonieDao colonieDao;
    PersonneDao personneDao;

    SecurityService securityService;

    @Override
    public Colonie saveColonie(ColonieAddDto colonieAddDto) {
        Colonie colonie = new Colonie( colonieAddDto.getDescription(), colonieAddDto.getDateAjout(), colonieAddDto.getName(), colonieAddDto.getDateDebut(), colonieAddDto.getDateFin(), colonieAddDto.getTheme(), colonieAddDto.getAvailability(), colonieAddDto.getUrlImage());
        colonieDao.save(colonie);
        return colonie;
    }

    @Override
    public List<Personne> findColoniePersonnes(long id) {
        return personneDao.findByColonieId(id);
    }

    /// Setters ///

    @Autowired
    public void setColonieDao(ColonieDao colonieDao) {
        this.colonieDao = colonieDao;
    }
    @Autowired
    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

}
