package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Amendes")
public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double montant;
    private LocalDateTime dateRetard;
    private int nbDeJoursEnRetard;
    private String nomDuDocument;
    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private Client client;

    public Amende(double montant, LocalDateTime dateRetard, int nbDeJoursEnRetard, String nomDuDocument, Client client) {
        this.montant = montant;
        this.dateRetard = dateRetard;
        this.nbDeJoursEnRetard = nbDeJoursEnRetard;
        this.nomDuDocument = nomDuDocument;
        this.client = client;
    }
}
