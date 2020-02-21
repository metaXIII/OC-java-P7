package com.librairie.librairie.impl;

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
}
