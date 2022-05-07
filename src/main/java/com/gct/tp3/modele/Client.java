package com.gct.tp3.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Client")
public class Client extends Personne {

    @OneToMany(mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(nullable = true)
    @JsonBackReference(value = "client_emprunts")
    @ToString.Exclude
    private List<Emprunt> emprunts = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(nullable = true)
    @JsonBackReference(value = "client_amendes")
    @ToString.Exclude
    private List<Amende> amendes = new ArrayList<>();

    public Client(String prenom, String nom, String username, String password, String email, String telephone,
                  String rue, String codePostal, String numeroCivique, List<Emprunt> emprunts, List<Amende> amendes) {
        super(prenom, nom, username, password, email, telephone, rue, codePostal, numeroCivique);
        this.emprunts = emprunts;
        this.amendes = amendes;
    }
}
