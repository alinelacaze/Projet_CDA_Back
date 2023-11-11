package com.formation.service.impl;

import com.formation.entity.Catalogue;
import com.formation.entity.Colonie;
import com.formation.entity.Personne;
import com.formation.repository.CatalogueDao;
import com.formation.repository.ColonieDao;
import com.formation.repository.PersonneDao;
import com.formation.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    CatalogueDao catalogueDao;

    @Override
    public List<Catalogue> displayCatalogue() {
        return catalogueDao.displayCatalogue();
    }

    @Autowired
    public void setCatalogueDao(CatalogueDao catalogueDao) {
        this.catalogueDao = catalogueDao;
    }


}
