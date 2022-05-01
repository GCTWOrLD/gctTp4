package com.gct.tp3.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Client")
public class Client extends Personne {

    @OneToMany(mappedBy = "client")
    @Column(nullable = true)
    @JsonBackReference
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @Column(nullable = true)
    @JsonBackReference
    private List<Amende> amendes = new ArrayList<>();

    public Client(String prenom, String nom, String username, String password, String email, String telephone,
                  String rue, String codePostal, String numeroCivique, List<Emprunt> emprunts, List<Amende> amendes) {
        super(prenom, nom, username, password, email, telephone, rue, codePostal, numeroCivique);
        this.emprunts = emprunts;
        this.amendes = amendes;
    }
}
