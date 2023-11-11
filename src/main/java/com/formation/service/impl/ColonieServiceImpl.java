package com.formation.service.impl;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.entity.dto.ColonieAddDto;
import com.formation.entity.dto.ColonieDeleteDto;
import com.formation.entity.dto.ColonieUpdateDto;
import com.formation.repository.CatalogueDao;
import com.formation.repository.ColonieDao;
import com.formation.repository.PersonneDao;
import com.formation.service.ColonieService;
import com.formation.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColonieServiceImpl implements ColonieService {

    ColonieDao colonieDao;

    SpaceService spaceService;

    @Override
    public List<Colonie> displayColonie() {
        return colonieDao.displayColonie();
    }

    @Override
    public List<Colonie> displayAllColonie() {return colonieDao.displayAllColonie(); }

    @Override
    public List<Colonie> displaySpringColonie() {
        return colonieDao.displaySpringColonie();
    }

    @Override
    public List<Colonie> displaySummerColonie() {
        return colonieDao.displaySummerColonie();
    }

    @Override
    public List<Colonie> displayFallColonie() {
        return colonieDao.displayFallColonie();
    }

    @Override
    public List<Colonie> displayWinterColonie() {
        return colonieDao.displayWinterColonie();
    }

    @Override
    public List<Colonie> displayFinishedColonie() {
        return colonieDao.displayFinishedColonie();
    }

    @Override
    public List<Colonie> displayToDeleteColonie() {
        return colonieDao.displayToDeleteColonie();
    }

    @Override
    public Colonie findColonie(long id) {
        return colonieDao.findById(id);
    }

    @Override
    public Colonie updateColonie(ColonieUpdateDto colonieUpdateDto) {
        List<Colonie> colonies = colonieDao.displayAllColonie();
        Colonie updatedColonie = colonies.stream().filter(col -> col.getId().equals(colonieUpdateDto.getId())).collect(Collectors.toList()).get(0);
        updatedColonie.setName(colonieUpdateDto.getName());
        updatedColonie.setDateDebut(colonieUpdateDto.getDateDebut());
        updatedColonie.setDateFin(colonieUpdateDto.getDateFin());
        updatedColonie.setTheme(colonieUpdateDto.getTheme());
        updatedColonie.setAvailability(colonieUpdateDto.getAvailability());
        updatedColonie.setUrlImage(colonieUpdateDto.getUrlImage());
        colonieDao.save(updatedColonie);
        return updatedColonie;
    }

    @Override
    public void deleteColonie(long id) {
        colonieDao.deleteById(id);
    }


    @Autowired
    public void setColonieDao(ColonieDao colonieDao) {
        this.colonieDao = colonieDao;
    }

}
