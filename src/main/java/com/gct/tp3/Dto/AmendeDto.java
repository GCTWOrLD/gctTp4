package com.gct.tp3.Dto;

import com.gct.tp3.modele.Client;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AmendeDto {

    private long id;
    private double montant;
    private LocalDateTime dateRetard;
    private int nbDeJoursEnRetard;
    private String nomDuDocument;
    private Client client;
}
