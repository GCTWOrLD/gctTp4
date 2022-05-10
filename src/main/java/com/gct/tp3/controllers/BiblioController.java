package com.gct.tp3.controllers;

import com.gct.tp3.Dto.*;
import com.gct.tp3.modele.*;
import com.gct.tp3.service.MapService;
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

    private MapService mapService;

    public BiblioController(MapService mapService) {
        this.mapService = mapService;
    }

    // Documents

    @GetMapping("/documents/titre/{titre}")
    public List<DocumentDto> getAllDocumentsLikeTitre(@PathVariable String titre) {
        logger.info("getAllDocumentsLikeTitre");
        return mapService.findByTitre(titre);
    }

    @GetMapping("/documents/auteur/{auteur}")
    public List<DocumentDto> getAllDocumentsFromAuteur(@PathVariable String auteur) {
        logger.info("getAllDocumentsFromAuteur");
        return mapService.findByAuteur(auteur);
    }

    @GetMapping("/documents/categorie/{categorie}")
    public List<DocumentDto> getAllDocumentsFromCategorie(@PathVariable String categorie) {
        logger.info("getAllDocumentsFromCategorie");
        return mapService.findByCategorie(categorie);
    }

    @GetMapping("/documents/annee/{annee}")
    public List<DocumentDto> getAllDocumentsFromYear(@PathVariable int annee) {
        logger.info("getAllDocumentsFromYear");
        return mapService.findByAnnee(annee);
    }

    // Emprunts

    @GetMapping("/emprunts")
    public List<EmpruntDto> getAllEmprunts() {
        logger.info("getAllEmprunts");
        return mapService.getAllEmprunts();
    }

    @GetMapping("/emprunts/{id}")
    public ResponseEntity<EmpruntDto> getEmprunt(@PathVariable Long id) {
        logger.info("findEmpruntById " + id);
        return mapService.findEmpruntById(id)
                .map(empruntDto -> ResponseEntity.status(HttpStatus.CREATED).body(empruntDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/emprunts/client/{id}")
    public List<EmpruntDto> getAllEmpruntsWithClientId(@PathVariable Long id) {
        logger.info("getAllEmpruntsWithClientId " + id);
        return mapService.getAllEmpruntsOfClient(id);
    }

    /*@PostMapping("/emprunts")
    public ResponseEntity<Emprunt> emprunterDocument(@RequestBody EmpruntDto newEmpruntDto, @PathVariable ClientDto clientDto, @PathVariable DocumentDto documentDto) {
        logger.info("post - createEmprunt " + newEmpruntDto);
        return mapService.emprunterDocument(clientDto, documentDto)
                .map(empruntDto -> ResponseEntity.status(HttpStatus.CREATED).body(empruntDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }*/

    @DeleteMapping("/emprunts/{id}")
    public ResponseEntity<Long> retournerDocument(EmpruntDto oldEmpruntDto, @PathVariable Long id) {
        logger.info("delete - retournerEmprunt " + id);
        mapService.retournerDocument(oldEmpruntDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Amendes

    @GetMapping("/amendes")
    public List<AmendeDto> getAllAmendes() {
        logger.info("getAllAmendes");
        return mapService.getAllAmendes();
    }

    @GetMapping("/amendes/{id}")
    public ResponseEntity<AmendeDto> getAmende(@PathVariable Long id) {
        logger.info("findAmendeById " + id);
        return mapService.findAmendeById(id)
                .map(amendeDto -> ResponseEntity.status(HttpStatus.CREATED).body(amendeDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/amendes/client/{id}")
    public List<AmendeDto> getAllAmendesWithClientId(@PathVariable Long id) {
        logger.info("getAllAmendesWithClientId " + id);
        return mapService.getAllAmendesOfClient(id);
    }

    @DeleteMapping("/amendes/{id}")
    public ResponseEntity<Long> payerAmmende(AmendeDto oldAmendeDto, @PathVariable Long id) {
        logger.info("delete - payerAmende " + id);
        mapService.deleteAmende(oldAmendeDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Livres

    @GetMapping("/livres")
    public List<LivreDto> getAllLivres() {
        logger.info("getAllLivres");
        return mapService.getAllLivres();
    }

    @GetMapping("/livres/{id}")
    public ResponseEntity<LivreDto> getLivre(@PathVariable Long id) {
        logger.info("findLivreById " + id);
        return mapService.findLivreById(id)
                .map(livreDto -> ResponseEntity.status(HttpStatus.CREATED).body(livreDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/livres")
    public ResponseEntity<Livre> createLivre(@RequestBody LivreDto newLivreDto) {
        logger.info("post - createLivre " + newLivreDto);
        return mapService.saveLivre(newLivreDto)
                .map(livreDto -> ResponseEntity.status(HttpStatus.CREATED).body(livreDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/livres/{id}")
    public ResponseEntity<Livre> updateLivre(@RequestBody LivreDto newLivreDto, @PathVariable Long id) {
        logger.info("update - updateLivre " + newLivreDto);
        return mapService.saveLivre(newLivreDto)
                .map(livreDto -> ResponseEntity.status(HttpStatus.CREATED).body(livreDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/livres/{id}")
    public ResponseEntity<Long> deleteLivre(LivreDto oldLivreDto, @PathVariable Long id) {
        logger.info("delete - deleteLivre " + id);
        mapService.deleteLivre(oldLivreDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Cds

    @GetMapping("/cds")
    public List<CdDto> getAllCds() {
        logger.info("getAllCds");
        return mapService.getAllCds();
    }

    @GetMapping("/cds/{id}")
    public ResponseEntity<CdDto> getCd(@PathVariable Long id) {
        logger.info("findCdById " + id);
        return mapService.findCdById(id)
                .map(cdDto -> ResponseEntity.status(HttpStatus.CREATED).body(cdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/cds")
    public ResponseEntity<Cd> createCd(@RequestBody CdDto newCdDto) {
        logger.info("post - createCd " + newCdDto);
        return mapService.saveCd(newCdDto)
                .map(cdDto -> ResponseEntity.status(HttpStatus.CREATED).body(cdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/cds/{id}")
    public ResponseEntity<Cd> updateCd(@RequestBody CdDto newCdDto, @PathVariable Long id) {
        logger.info("update - updateCd " + newCdDto);
        return mapService.saveCd(newCdDto)
                .map(cdDto -> ResponseEntity.status(HttpStatus.CREATED).body(cdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/cds/{id}")
    public ResponseEntity<Long> deleteCd(CdDto oldCdDto, @PathVariable Long id) {
        logger.info("delete - deleteCd " + id);
        mapService.deleteCd(oldCdDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Dvds

    @GetMapping("/dvds")
    public List<DvdDto> getAllDvds() {
        logger.info("getAllDvs");
        return mapService.getAllDvds();
    }

    @GetMapping("/dvds/{id}")
    public ResponseEntity<DvdDto> getDvd(@PathVariable Long id) {
        logger.info("findDvdById " + id);
        return mapService.findDvdById(id)
                .map(dvdDto -> ResponseEntity.status(HttpStatus.CREATED).body(dvdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/dvds")
    public ResponseEntity<Dvd> createDvd(@RequestBody DvdDto newDvdDto) {
        logger.info("post - createDvd " + newDvdDto);
        return mapService.saveDvd(newDvdDto)
                .map(dvdDto -> ResponseEntity.status(HttpStatus.CREATED).body(dvdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/dvds/{id}")
    public ResponseEntity<Dvd> updateDvd(@RequestBody DvdDto newDvdDto, @PathVariable Long id) {
        logger.info("update - updateDvd " + newDvdDto);
        return mapService.saveDvd(newDvdDto)
                .map(dvdDto -> ResponseEntity.status(HttpStatus.CREATED).body(dvdDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/dvds/{id}")
    public ResponseEntity<Long> deleteDvd(DvdDto oldDvdDto, @PathVariable Long id) {
        logger.info("delete - deleteDvd " + id);
        mapService.deleteDvd(oldDvdDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Clients

    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        logger.info("getAllClients");
        return mapService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        logger.info("findClientById " + id);
        return mapService.findClientById(id)
                .map(clientDto -> ResponseEntity.status(HttpStatus.CREATED).body(clientDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody ClientDto newClientDto) {
        logger.info("post - createClient " + newClientDto);
        return mapService.saveClient(newClientDto)
                .map(clientDto -> ResponseEntity.status(HttpStatus.CREATED).body(clientDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody ClientDto newClientDto, @PathVariable Long id) {
        logger.info("update - updateClient " + newClientDto);
        return mapService.saveClient(newClientDto)
                .map(clientDto -> ResponseEntity.status(HttpStatus.CREATED).body(clientDto))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Long> deleteClient(ClientDto oldClientDto, @PathVariable Long id) {
        logger.info("delete - deleteClient " + id);
        mapService.deleteClient(oldClientDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
