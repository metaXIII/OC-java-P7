package com.librairie.librairie.impl;

import com.librairie.librairie.dto.CollectionDto;
import com.librairie.librairie.model.Livre;
import com.librairie.librairie.repositories.LibrairieRepository;
import com.librairie.librairie.service.ILibrairieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LibrarieServiceImpl implements ILibrairieService {
    @Autowired
    private LibrairieRepository librairieRepository;

    @Override
    public List<Livre> findAll() {
        return librairieRepository.findAll();
    }

    @Override
    public List<Livre> find(CollectionDto collectionDto) {
        if (collectionDto.getNom().isEmpty())
            collectionDto.setNom("%");
        if (collectionDto.getAuteur().isEmpty())
            collectionDto.setAuteur("%");
        if (collectionDto.getCategorie().isEmpty())
            collectionDto.setCategorie("%");
        return librairieRepository.findByNomAndAuteurAndCategorieIgnoreCase(collectionDto.getNom(), collectionDto.getAuteur(), collectionDto.getCategorie());
    }
}
