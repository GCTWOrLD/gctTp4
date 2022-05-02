package com.gct.tp3.repository;

import com.gct.tp3.modele.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    Livre findByTitreAndAuteur(String titreDocument, String auteurDocument);
}
