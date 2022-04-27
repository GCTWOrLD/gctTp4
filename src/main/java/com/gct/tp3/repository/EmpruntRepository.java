package com.gct.tp3.repository;

import com.gct.tp3.modele.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    /*@Query("select e.document.id, e.dateRetour from Emprunt e where e.client.id = ?1")
    List<Emprunt> findEmpruntsAndDateRetour(Long id);*/
}
