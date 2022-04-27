package com.gct.tp3.modele;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;

    @ManyToOne
    @JoinColumn(name = "Client_ID")
    private Client client;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Document_ID", referencedColumnName = "id")
    private Document document;

    public Emprunt(LocalDateTime dateEmprunt, LocalDateTime dateRetour, Client client, Document document) {
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.client = client;
        this.document = document;
    }
}
