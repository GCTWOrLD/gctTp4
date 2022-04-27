package com.gct.tp3.forms;

import com.gct.tp3.modele.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientForm {
    private String id;
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

    public ClientForm(String id, String prenom, String nom, String username,
                      String password, String email, String telephone,
                      String rue, String codePostal, String numeroCivique) {
        this.id = id;
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

    public ClientForm(Client client) {
        this(Long.toString(client.getId()), client.getPrenom(), client.getNom(),
                client.getUsername(), client.getPassword(), client.getEmail(),
                client.getTelephone(), client.getRue(), client.getCodePostal(),
                client.getNumeroCivique());
    }

    public Client toClient() {
        return new Client(prenom, nom, username, password, email, telephone, rue, codePostal, numeroCivique, null, null);
    }
}
