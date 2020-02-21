package com.librairie.librairie.repositories;

import com.librairie.librairie.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrairieRepository extends JpaRepository<Livre, Long> {
}
