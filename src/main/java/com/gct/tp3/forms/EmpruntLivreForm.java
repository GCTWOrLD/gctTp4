package com.gct.tp3.forms;

import com.gct.tp3.modele.Emprunt;
import com.gct.tp3.service.BiblioService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
public class EmpruntLivreForm {
    private String id;
    private String username;
    private String nomLivre;
    private String nomAuteur;

    @Autowired
    private BiblioService service;

    public EmpruntLivreForm(String id, String username, String nomLivre, String nomAuteur) {
        this.id = id;
        this.username = username;
        this.nomLivre = nomLivre;
        this.nomAuteur = nomAuteur;
    }

    public EmpruntLivreForm(Emprunt emprunt) {
        this(Long.toString(emprunt.getId()), null,
                null, null);
    }

    public Emprunt toEmprunt() {
        return new Emprunt(LocalDateTime.now(),
                LocalDateTime.now().plus(3, ChronoUnit.WEEKS),
                service.findByUsername(username), service.findByTitreAndAuteur(nomLivre, nomAuteur));
    }
}
