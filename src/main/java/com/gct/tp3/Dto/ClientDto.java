package com.gct.tp3.Dto;

import lombok.Data;

@Data
public class ClientDto {

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
}
