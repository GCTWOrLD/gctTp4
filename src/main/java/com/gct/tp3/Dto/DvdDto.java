package com.gct.tp3.Dto;

import lombok.Data;

@Data
public class DvdDto {

    private long id;
    private String titre;
    private String auteur;
    private int annee;
    private String categorie;
    private int examplaires;
    private String duree;
    private String studio;
}
