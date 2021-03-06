package com.librairie.librairie.impl;

import com.librairie.librairie.dto.CollectionDto;
import com.librairie.librairie.model.Livre;
import com.librairie.librairie.repositories.LibrairieRepository;
import com.librairie.librairie.service.ILibrairieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(LibrarieServiceImpl.class);

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
        return new ResponseEntity<>(librairieRepository.findById(id), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> reserve(String id) {
        Optional<Livre> livre = librairieRepository.findById(Long.parseLong(id));
        if (livre.isPresent()) {
            if (livre.get().getQuantite() <= 0)
                return new ResponseEntity<>(false, HttpStatus.CONFLICT);
            livre.get().setQuantite(livre.get().getQuantite() - 1);
            librairieRepository.save(livre.get());
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }
        if (logger.isErrorEnabled())
            logger.error(String.format("Le livre n'a pas été trouvé avec l'id %s", id));
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
