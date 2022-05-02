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

    //Livres

    @GetMapping("/livres")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Livre> getAllLivres() {
        logger.info(("getAllLivres"));
        return service.getAllLivres();
    }

    @GetMapping ("/livres/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        logger.info("findLivreById " + id);
        return service.findLivreById(id)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
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

    // Clients

    @GetMapping("/clients")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Client> getAllClients() {
        logger.info(("getAllClients"));
        return service.getAllClients();
    }

    @GetMapping ("/clients/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        logger.info("findClientById " + id);
        return service.findClientById(id)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/clients")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {
        logger.info("post - createClient " + newClient);
        return service.saveClient(newClient)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/clients/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Client> updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        logger.info("update - updateClient " + newClient);
        return service.saveClient(newClient)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/clients/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> deleteClient(Client oldClient, @PathVariable Long id) {
        logger.info(("delete - deleteClient " + id));
        service.deleteClient(oldClient);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
