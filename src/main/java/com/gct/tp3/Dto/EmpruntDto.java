package com.gct.tp3.Dto;

import com.gct.tp3.modele.Client;
import com.gct.tp3.modele.Document;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpruntDto {

    private long id;
    private LocalDateTime dateEmprunt;
    private LocalDateTime dateRetour;
    private Client client;
    private Document document;
}
