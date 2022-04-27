package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Livre")
public class Livre extends Document {
    private String editeur;

    public Livre(String titre, String auteur, int annee, String categorie, int examplaires, String editeur) {
        super(titre, auteur, annee, categorie, examplaires);
        this.editeur = editeur;
    }
}
