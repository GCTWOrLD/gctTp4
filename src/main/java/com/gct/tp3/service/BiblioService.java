package com.gct.tp3.service;

import com.gct.tp3.modele.*;
import com.gct.tp3.repository.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BiblioService {

    private final double FRAIS_RETARD_PAR_JOUR = 0.25;

    private AmendeRepository amendeRepository;

    private DocumentRepository documentRepository;

    private LivreRepository livreRepository;

    private CdRepository cdRepository;

    private DvdRepository dvdRepository;

    private EmpruntRepository empruntRepository;

    private ClientRepository clientRepository;

    public BiblioService(ClientRepository clientRepository,
                      AmendeRepository amendeRepository,
                      DocumentRepository documentRepository,
                      LivreRepository livreRepository,
                      CdRepository cdRepository,
                      DvdRepository dvdRepository,
                      EmpruntRepository empruntRepository) {
        this.clientRepository = clientRepository;
        this.amendeRepository = amendeRepository;
        this.documentRepository = documentRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.empruntRepository = empruntRepository;
    }

    public Client saveClient(String prenom, String nom, String username,
                             String password, String email, String telephone,
                             String rue, String codePostal, String numeroCivique) {
        return clientRepository.save(new Client(prenom, nom, username,
                password, email, telephone, rue, codePostal,
                numeroCivique, null, null));
    }

    public Optional<Client> saveClient(Client client) {
        return Optional.of(clientRepository.save(client));
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Livre saveLivre(String titre, String auteur, int annee, String categorie, int examplaires, String editeur) {
        return documentRepository.save(new Livre(titre, auteur, annee, categorie, examplaires, editeur));
    }

    public Optional<Livre> saveLivre(Livre livre) {
        return Optional.of(documentRepository.save(livre));
    }

    public void deleteLivre(Livre livre) {
        documentRepository.delete(livre);
    }

    public Dvd saveDvd(String titre, String auteur, int annee, String categorie, int examplaires, String duree, String studio) {
        return documentRepository.save(new Dvd(titre, auteur, annee, categorie, examplaires, duree, studio));
    }

    public Optional<Dvd> saveDvd(Dvd dvd) {
        return Optional.of(dvdRepository.save(dvd));
    }

    public void deleteDvd(Dvd dvd) {
        dvdRepository.delete(dvd);
    }

    public Cd saveCd(String titre, String auteur, int annee, String categorie, int examplaires, String duree, String studio) {
        return documentRepository.save(new Cd(titre, auteur, annee, categorie, examplaires, duree, studio));
    }

    public Optional<Cd> saveCd(Cd cd) {
        return Optional.of(cdRepository.save(cd));
    }

    public void deleteCd(Cd cd) {
        cdRepository.delete(cd);
    }

    public Emprunt saveEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    public Livre findByTitreAndAuteur(String titreDocument, String auteurDocument) {
        return livreRepository.findByTitreAndAuteur(titreDocument, auteurDocument);
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

    public Optional<Emprunt> emprunterDocument(Client client, Document doc) {
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
            clientRepository.save(client);
            documentRepository.save(doc);
            System.out.println("Emprunt effectu??.");
            return Optional.of(empruntRepository.save(emprunt));
        } else {
            System.out.println("IL ne reste plus d'examplaires de ce document.");
            return null;
        }
    }

    public void retournerDocument(Emprunt emprunt) {
        Optional<Emprunt> oldEmprunt = findEmpruntById(emprunt.getId());
        Document doc = oldEmprunt.get().getDocument();
        doc.setExamplaires(doc.getExamplaires() + 1);
        documentRepository.save(doc);
        empruntRepository.delete(emprunt);
    }

    public void payerFraisRetard(Amende amende) {
        amendeRepository.delete(amende);
        System.out.println("Frais pay??s.");
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
                System.out.println("L'amende a ??t?? g??n??r??e.");
            } else {
                System.out.println("Aucun emprunts en retard.");
            }
        }
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> findLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Cd> getAllCds() {
        return cdRepository.findAll();
    }

    public Optional<Cd> findCdById(Long id) {
        return cdRepository.findById(id);
    }

    public List<Dvd> getAllDvds() {
        return dvdRepository.findAll();
    }

    public Optional<Dvd> findDvdById(Long id) {
        return dvdRepository.findById(id);
    }

    public List<Emprunt> getAllEmpruntsOfClient(Long id) {
        return empruntRepository.findAllByClientId(id);
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> findEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    public List<Amende> getAllAmendes() {
        return amendeRepository.findAll();
    }

    public Optional<Amende> findAmendeById(Long id) {
        return amendeRepository.findById(id);
    }

    public List<Amende> getAllAmendesOfClient(Long id) {
        return amendeRepository.findAllByClientId(id);
    }
}
