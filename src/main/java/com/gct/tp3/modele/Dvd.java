package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Dvd")
public class Dvd extends Document {
    private String duree;
    private String studio;

    public Dvd(String titre, String auteur, int annee, String categorie, int examplaires, String duree, String studio) {
        super(titre, auteur, annee, categorie, examplaires);
        this.duree = duree;
        this.studio = studio;
    }
}
