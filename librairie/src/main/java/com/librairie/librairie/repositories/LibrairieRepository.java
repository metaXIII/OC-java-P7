package com.librairie.librairie.repositories;

import com.librairie.librairie.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibrairieRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByNomContainingIgnoreCaseAndNomContainingIgnoreCaseAndCategorieContainingIgnoreCase(@Param("nom") String nom,
                                                                                                        @Param("auteur") String auteur,
                                                                                                        @Param("categorie") String categorie);

    Optional<Livre> findById(long id);
}
