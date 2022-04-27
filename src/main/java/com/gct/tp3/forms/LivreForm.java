package com.gct.tp3.forms;

import com.gct.tp3.modele.Livre;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivreForm {
    private String id;
    private String titre;
    private String auteur;
    private int annee;
    private String categorie;
    private int examplaires;
    private String editeur;

    public LivreForm(String id, String titre, String auteur,
                     int annee, String categorie, int examplaires,
                     String editeur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.categorie = categorie;
        this.examplaires = examplaires;
        this.editeur = editeur;
    }

    public LivreForm(Livre livre) {
        this(Long.toString(livre.getId()), livre.getTitre(), livre.getAuteur(),
                livre.getAnnee(), livre.getCategorie(), livre.getExamplaires(),
                livre.getEditeur());
    }

    public Livre toLivre() {
        return new Livre(titre, auteur, annee, categorie, examplaires, editeur);
    }
}
