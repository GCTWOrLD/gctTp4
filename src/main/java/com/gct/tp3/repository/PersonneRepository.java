package com.gct.tp3.repository;

import com.gct.tp3.modele.Client;
import com.gct.tp3.modele.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    Client findByUsername(String username);
}
