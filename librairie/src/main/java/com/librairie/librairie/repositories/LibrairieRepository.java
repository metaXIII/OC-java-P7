package com.librairie.librairie.repositories;

import com.librairie.librairie.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrairieRepository extends JpaRepository<Livre, Long> {
    @Query(value = "select * " +
            "from Livre " +
            "where ")
    List<Livre> findByNomAndAuteurAndCategorieIgnoreCase(String nom, String auteur, String categorie);
}
