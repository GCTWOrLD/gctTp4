package com.gct.tp3.repository;

import com.gct.tp3.modele.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
