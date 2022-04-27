package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Personne")
@Table(name = "Personnes")
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String prenom;
    private String nom;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String rue;
    private final String VILLE = "Javatown";
    private final String PROVINCE = "QC";
    private String codePostal;
    private String numeroCivique;

    public Personne(String prenom, String nom, String username, String password, String email, String telephone,
                    String rue, String codePostal, String numeroCivique) {
        this.prenom = prenom;
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.numeroCivique = numeroCivique;
    }
}
