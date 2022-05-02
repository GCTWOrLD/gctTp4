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

    // Documents

    @GetMapping("/documents/{annee}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Document> getAllDocumentsFromYear(@PathVariable int annee) {
        logger.info("getAllDocumentsFromYear");
        return service.findByAnnee(annee);
    }

    // Livres

    @GetMapping("/livres")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Livre> getAllLivres() {
        logger.info("getAllLivres");
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

    // Cds

    @GetMapping("/cds")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Cd> getAllCds() {
        logger.info("getAllCds");
        return service.getAllCds();
    }

    @GetMapping ("/cds/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Cd> getCd(@PathVariable Long id) {
        logger.info("findCdById " + id);
        return service.findCdById(id)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/cds")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Cd> createCd(@RequestBody Cd newCd) {
        logger.info("post - createCd " + newCd);
        return service.saveCd(newCd)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/cds/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Cd> updateCd(@RequestBody Cd newCd, @PathVariable Long id) {
        logger.info("update - updateCd " + newCd);
        return service.saveCd(newCd)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/cds/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> deleteCd(Cd oldCd, @PathVariable Long id) {
        logger.info(("delete - deleteCd " + id));
        service.deleteCd(oldCd);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Dvds

    @GetMapping("/dvds")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Dvd> getAllDvds() {
        logger.info("getAllDvs");
        return service.getAllDvds();
    }

    @GetMapping ("/dvds/{id}")
    @CrossOrigin(origins = "http:/localhost:3000")
    public ResponseEntity<Dvd> getDvd(@PathVariable Long id) {
        logger.info("findDvdById " + id);
        return service.findDvdById(id)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/dvds")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Dvd> createDvd(@RequestBody Dvd newDvd) {
        logger.info("post - createDvd " + newDvd);
        return service.saveDvd(newDvd)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/dvds/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Dvd> updateDvd(@RequestBody Dvd newDvd, @PathVariable Long id) {
        logger.info("update - updateDvd " + newDvd);
        return service.saveDvd(newDvd)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/dvds/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Long> deleteDvd(Dvd oldDvd, @PathVariable Long id) {
        logger.info(("delete - deleteDvd " + id));
        service.deleteDvd(oldDvd);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Clients

    @GetMapping("/clients")
    @CrossOrigin(origins = "http:/localhost:3000")
    public List<Client> getAllClients() {
        logger.info("getAllClients");
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
