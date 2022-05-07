package com.gct.tp3.repository;

import com.gct.tp3.modele.Amende;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmendeRepository extends JpaRepository<Amende, Long> {
    @Query(value = "select a from Amende a where a.client.id = ?1")
    List<Amende> findAllByClientId(Long id);
}
