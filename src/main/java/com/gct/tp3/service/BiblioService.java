package com.gct.tp3.service;

import com.gct.tp3.modele.*;
import com.gct.tp3.repository.AmendeRepository;
import com.gct.tp3.repository.DocumentRepository;
import com.gct.tp3.repository.EmpruntRepository;
import com.gct.tp3.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BiblioService {

    private final double FRAIS_RETARD_PAR_JOUR = 0.25;

    @Autowired
    private AmendeRepository amendeRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private PersonneRepository personneRepository;

    public Client saveClient(String prenom, String nom, String username,
                             String password, String email, String telephone,
                             String rue, String codePostal, String numeroCivique) {
        return personneRepository.save(new Client(prenom, nom, username,
                password, email, telephone, rue, codePostal,
                numeroCivique, null, null));
    }

    public Client saveClient(Client client) {
        return personneRepository.save(client);
    }

    public Livre saveLivre(String titre, String auteur, int annee, String categorie, int examplaires, String editeur) {
        return documentRepository.save(new Livre(titre, auteur, annee, categorie, examplaires, editeur));
    }

    public Optional<Livre> saveLivre(Livre livre) {
        return Optional.of(documentRepository.save(livre));
    }

    public Dvd saveDvd(String titre, String auteur, int annee, String categorie, int examplaires, String duree, String studio) {
        return documentRepository.save(new Dvd(titre, auteur, annee, categorie, examplaires, duree, studio));
    }

    public Cd saveCd(String titre, String auteur, int annee, String categorie, int examplaires, String duree, String studio) {
        return documentRepository.save(new Cd(titre, auteur, annee, categorie, examplaires, duree, studio));
    }

    public Emprunt saveEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public Client findByUsername(String username) {
        return personneRepository.findByUsername(username);
    }

    public Livre findByTitreAndAuteur(String titreDocument, String auteurDocument) {
        return documentRepository.findByTitreAndAuteur(titreDocument, auteurDocument);
    }

    public List<Document> findByAuteur(String auteurDocument) {
        return documentRepository.findByAuteur(auteurDocument);
    }

    public List<Document> findByAnnee(int annee) {
        return documentRepository.findByAnnee(annee);
    }

    public List<Document> findByTitre(String titreDocument) {
        return documentRepository.findByTitre(titreDocument);
    }

    public List<Document> findByCategorie(String categorie) {
        return documentRepository.findByCategorie(categorie);
    }

    public void emprunterDocument(Client client, Document doc) {
        if (client.getEmprunts() == null) {
            List<Emprunt> emprunts = new ArrayList<>();
            client.setEmprunts(emprunts);
        }
        Emprunt emprunt = new Emprunt(LocalDateTime.now(), null, client, doc);
        if (doc.getExamplaires() > 0) {
            if (doc.getClass().equals(Livre.class)) {
                emprunt.setDateRetour(LocalDateTime.now().plus(3, ChronoUnit.WEEKS));
            } else if (doc.getClass().equals(Cd.class)) {
                emprunt.setDateRetour(LocalDateTime.now().plus(2, ChronoUnit.WEEKS));
            } else if (doc.getClass().equals(Dvd.class)) {
                emprunt.setDateRetour(LocalDateTime.now().plus(1, ChronoUnit.WEEKS));
            }
            doc.setExamplaires(doc.getExamplaires() - 1);
            client.getEmprunts().add(emprunt);
            personneRepository.save(client);
            empruntRepository.save(emprunt);
            documentRepository.save(doc);
            System.out.println("Emprunt effectué.");
        } else {
            System.out.println("IL ne reste plus d'examplaires de ce document.");
        }
    }

    public void retournerDocument(Client client, Document doc) {
        List<Emprunt> emprunts = client.getEmprunts();
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getDocument().equals(doc)) {
                emprunts.remove(emprunt);
                empruntRepository.delete(emprunt);
                doc.setExamplaires(doc.getExamplaires() + 1);
                documentRepository.save(doc);
                System.out.println("Retour effectué.");
            }
        }
        personneRepository.save(client);
    }

    public void payerFraisRetard(Client client) {
        if (client.getAmendes() != null) {
            List<Amende> amendes = client.getAmendes();
            for (Amende amende : amendes) {
                amendes.remove(amende);
                amendeRepository.delete(amende);
            }
            personneRepository.save(client);
            System.out.println("Frais payés.");
        } else {
            System.out.println("Vous n'avez pas de frais à payer.");
        }
    }

    public void genererAmendes() {
        List<Emprunt> emprunts = empruntRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        iterationDesEmpruntsPourGenererAmendes(emprunts, now);
    }

    public void genererAmendesBidon() {
        List<Emprunt> emprunts = empruntRepository.findAll();
        LocalDateTime now = LocalDateTime.now().plusDays(60);
        iterationDesEmpruntsPourGenererAmendes(emprunts, now);
    }

    public void iterationDesEmpruntsPourGenererAmendes(List<Emprunt> emprunts, LocalDateTime now) {
        for (Emprunt emprunt : emprunts) {
            if (now.isAfter(emprunt.getDateRetour())) {
                long jours = ChronoUnit.DAYS.between(emprunt.getDateRetour(), now);
                double montant = jours * FRAIS_RETARD_PAR_JOUR;
                amendeRepository.save(new Amende(montant, now.minusDays(jours), Math.toIntExact(jours),
                        emprunt.getDocument().getTitre(),
                        emprunt.getClient()));
                System.out.println("Les amendes ont été générées.");
            } else {
                System.out.println("Aucun emprunts en retard.");
            }
        }
    }

    /*public List<Emprunt> listerEmprunts(long idClient) {
        return empruntRepository.findEmpruntsAndDateRetour(idClient);
    }*/

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> findDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    public List<Personne> getAllClients() {
        return personneRepository.findAll();
    }

    public Optional<Personne> findClientById(Long id) {
        return personneRepository.findById(id);
    }
}
