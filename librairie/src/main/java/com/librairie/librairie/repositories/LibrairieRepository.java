package com.librairie.librairie.repositories;

import com.librairie.librairie.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrairieRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByNomContainingIgnoreCaseAndNomContainingIgnoreCaseAndCategorieContainingIgnoreCase(@Param("nom") String nom,
                                                                                                        @Param("auteur") String auteur,
                                                                                                        @Param("categorie") String categorie);
}
