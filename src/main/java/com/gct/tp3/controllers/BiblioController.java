package com.gct.tp3.controllers;

import com.gct.tp3.modele.*;
import com.gct.tp3.service.BiblioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BiblioController {
    Logger logger = LoggerFactory.getLogger(BiblioController.class);

    private BiblioService service;

    public BiblioController(BiblioService service) {
        this.service = service;
    }

    // Documents

    @GetMapping("/documents/titre/{titre}")
    public List<Document> getAllDocumentsLikeTitre(@PathVariable String titre) {
        logger.info("getAllDocumentsLikeTitre");
        return service.findByTitre(titre);
    }

    @GetMapping("/documents/auteur/{auteur}")
    public List<Document> getAllDocumentsFromAuteur(@PathVariable String auteur) {
        logger.info("getAllDocumentsFromAuteur");
        return service.findByAuteur(auteur);
    }

    @GetMapping("/documents/categorie/{categorie}")
    public List<Document> getAllDocumentsFromCategorie(@PathVariable String categorie) {
        logger.info("getAllDocumentsFromCategorie");
        return service.findByCategorie(categorie);
    }

    @GetMapping("/documents/annee/{annee}")
    public List<Document> getAllDocumentsFromYear(@PathVariable int annee) {
        logger.info("getAllDocumentsFromYear");
        return service.findByAnnee(annee);
    }

    // Emprunts

    @PostMapping("/emprunts")
    public ResponseEntity<Emprunt> emprunterDocument(@RequestBody Emprunt newEmprunt, @PathVariable Client client, @PathVariable Document document) {
        logger.info("post - createEmprunt " + newEmprunt);
        return service.emprunterDocument(client, document)
                .map(emprunt -> ResponseEntity.status(HttpStatus.CREATED).body(emprunt))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/emprunts/{id}")
    public ResponseEntity<Long> retournerDocument(Emprunt oldEmprunt, @PathVariable Long id) {
        logger.info("delete - deleteEmprunt " + id);
        service.retournerDocument(oldEmprunt);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/emprunts/{id}")
    public List<Emprunt> getAllEmpruntsWithClientId(@PathVariable Long id) {
        logger.info("getAllEmpruntsWithClientId");
        return service.getAllEmpruntsOfClient(id);
    }

    // Livres

    @GetMapping("/livres")
    public List<Livre> getAllLivres() {
        logger.info("getAllLivres");
        return service.getAllLivres();
    }

    @GetMapping ("/livres/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        logger.info("findLivreById " + id);
        return service.findLivreById(id)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/livres")
    public ResponseEntity<Livre> createLivre(@RequestBody Livre newLivre) {
        logger.info("post - createLivre " + newLivre);
        return service.saveLivre(newLivre)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/livres/{id}")
    public ResponseEntity<Livre> updateLivre(@RequestBody Livre newLivre, @PathVariable Long id) {
        logger.info("update - updateLivre " + newLivre);
        return service.saveLivre(newLivre)
                .map(livre -> ResponseEntity.status(HttpStatus.CREATED).body(livre))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/livres/{id}")
    public ResponseEntity<Long> deleteLivre(Livre oldLivre, @PathVariable Long id) {
        logger.info("delete - deleteLivre " + id);
        service.deleteLivre(oldLivre);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Cds

    @GetMapping("/cds")
    public List<Cd> getAllCds() {
        logger.info("getAllCds");
        return service.getAllCds();
    }

    @GetMapping ("/cds/{id}")
    public ResponseEntity<Cd> getCd(@PathVariable Long id) {
        logger.info("findCdById " + id);
        return service.findCdById(id)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/cds")
    public ResponseEntity<Cd> createCd(@RequestBody Cd newCd) {
        logger.info("post - createCd " + newCd);
        return service.saveCd(newCd)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/cds/{id}")
    public ResponseEntity<Cd> updateCd(@RequestBody Cd newCd, @PathVariable Long id) {
        logger.info("update - updateCd " + newCd);
        return service.saveCd(newCd)
                .map(cd -> ResponseEntity.status(HttpStatus.CREATED).body(cd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/cds/{id}")
    public ResponseEntity<Long> deleteCd(Cd oldCd, @PathVariable Long id) {
        logger.info("delete - deleteCd " + id);
        service.deleteCd(oldCd);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Dvds

    @GetMapping("/dvds")
    public List<Dvd> getAllDvds() {
        logger.info("getAllDvs");
        return service.getAllDvds();
    }

    @GetMapping ("/dvds/{id}")
    public ResponseEntity<Dvd> getDvd(@PathVariable Long id) {
        logger.info("findDvdById " + id);
        return service.findDvdById(id)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/dvds")
    public ResponseEntity<Dvd> createDvd(@RequestBody Dvd newDvd) {
        logger.info("post - createDvd " + newDvd);
        return service.saveDvd(newDvd)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/dvds/{id}")
    public ResponseEntity<Dvd> updateDvd(@RequestBody Dvd newDvd, @PathVariable Long id) {
        logger.info("update - updateDvd " + newDvd);
        return service.saveDvd(newDvd)
                .map(dvd -> ResponseEntity.status(HttpStatus.CREATED).body(dvd))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/dvds/{id}")
    public ResponseEntity<Long> deleteDvd(Dvd oldDvd, @PathVariable Long id) {
        logger.info("delete - deleteDvd " + id);
        service.deleteDvd(oldDvd);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Clients

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        logger.info("getAllClients");
        return service.getAllClients();
    }

    @GetMapping ("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        logger.info("findClientById " + id);
        return service.findClientById(id)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) {
        logger.info("post - createClient " + newClient);
        return service.saveClient(newClient)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        logger.info("update - updateClient " + newClient);
        return service.saveClient(newClient)
                .map(client -> ResponseEntity.status(HttpStatus.CREATED).body(client))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Long> deleteClient(Client oldClient, @PathVariable Long id) {
        logger.info("delete - deleteClient " + id);
        service.deleteClient(oldClient);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
