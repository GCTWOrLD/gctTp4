package com.gct.tp3.controllers;

import com.gct.tp3.modele.*;
import com.gct.tp3.service.BiblioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BiblioController {
    Logger logger = LoggerFactory.getLogger(BiblioController.class);

    private BiblioService service;

    public BiblioController(BiblioService service) {
        this.service = service;
    }

    @GetMapping("/documents")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Document> getAllDocuments() {
        logger.info(("getAllDocuments"));
        return service.getAllDocuments();
    }

    @GetMapping ("/documents/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        logger.info("findDocumentById");
        return service.findDocumentById(id)
                .map(document -> ResponseEntity.status(HttpStatus.CREATED).body(document))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/livres")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Livre> createLivre(@RequestBody Livre newLivre) {
        logger.info("post - createLivre " + newLivre);
        return service.saveLivre(newLivre)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/livres/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Livre> updateLivre(@RequestBody Livre newLivre, @PathVariable Long id) {
        logger.info("update - updateLivre " + newLivre);
        return service.saveLivre(newLivre)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/livres/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> deleteLivre(Livre oldLivre, @PathVariable Long id) {
        logger.info(("delete - deleteLivre " + id));
        service.deleteLivre(oldLivre);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/clients")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Personne> getAllClients() {
        logger.info(("getAllClients"));
        return service.getAllClients();
    }

    @GetMapping ("/clients/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Personne> getClient(@PathVariable Long id) {
        logger.info("findClientById");
        return service.findClientById(id)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
