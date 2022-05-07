package com.gct.tp3.repository;

import com.gct.tp3.modele.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByAuteur(String auteurDocument);

    List<Document> findByAnnee(int annee);

    @Query("select d from Document d where d.titre like %:titreDocument%")
    List<Document> findByTitre(@Param("titreDocument") String text);

    List<Document> findByCategorie(String categorie);
}
