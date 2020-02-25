package com.librairie.librairie.impl;

import com.librairie.librairie.dto.CollectionDto;
import com.librairie.librairie.model.Livre;
import com.librairie.librairie.repositories.LibrairieRepository;
import com.librairie.librairie.service.ILibrairieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return librairieRepository.findByNomContainingIgnoreCaseAndNomContainingIgnoreCaseAndCategorieContainingIgnoreCase(collectionDto.getNom(), collectionDto.getAuteur(), collectionDto.getCategorie());
    }

    @Override
    public ResponseEntity<Optional<Livre>> findById(long id) {
        return new ResponseEntity<Optional<Livre>>(librairieRepository.findById(id), HttpStatus.ACCEPTED);
    }
}
