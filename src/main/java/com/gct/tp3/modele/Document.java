package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Document")
@Table(name = "Documents")
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String auteur;
    private int annee;
    private String categorie;
    private int examplaires;

    public Document(String titre, String auteur, int annee, String categorie, int examplaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.categorie = categorie;
        this.examplaires = examplaires;
    }
}
