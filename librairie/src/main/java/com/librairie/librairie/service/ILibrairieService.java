package com.librairie.librairie.service;

import com.librairie.librairie.dto.CollectionDto;
import com.librairie.librairie.model.Livre;

import java.util.List;

public interface ILibrairieService {
    List<Livre> findAll();

    List<Livre> find(CollectionDto collectionDto);
}
