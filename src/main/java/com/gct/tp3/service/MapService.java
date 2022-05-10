package com.gct.tp3.service;

import com.gct.tp3.Dto.*;
import com.gct.tp3.modele.*;
import com.gct.tp3.repository.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AmendeRepository amendeRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private CdRepository cdRepository;

    @Autowired
    private DvdRepository dvdRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(this::convertToClientDto).collect(Collectors.toList());
    }

    public Optional<ClientDto> findClientById(Long id) {
        return clientRepository.findById(id).map(this::convertToClientDto);
    }

    public Optional<Client> saveClient(ClientDto clientDto) {
        return Optional.of(clientRepository.save(convertToClient(clientDto)));
    }

    public void deleteClient(ClientDto clientDto) {
        clientRepository.delete(convertToClient(clientDto));
    }

    private ClientDto convertToClientDto(Client client) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }

    private Client convertToClient(ClientDto clientDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Client client = modelMapper.map(clientDto, Client.class);
        return client;
    }

    public List<LivreDto> getAllLivres() {
        return livreRepository.findAll().stream().map(this::convertToLivreDto).collect(Collectors.toList());
    }

    public Optional<LivreDto> findLivreById(Long id) {
        return livreRepository.findById(id).map(this::convertToLivreDto);
    }

    public Optional<Livre> saveLivre(LivreDto livreDto) {
        return Optional.of(livreRepository.save(convertToLivre(livreDto)));
    }

    public void deleteLivre(LivreDto livreDto) {
        livreRepository.delete(convertToLivre(livreDto));
    }

    private LivreDto convertToLivreDto(Livre livre) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        LivreDto livreDto = modelMapper.map(livre, LivreDto.class);
        return livreDto;
    }

    private Livre convertToLivre(LivreDto livreDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Livre livre = modelMapper.map(livreDto, Livre.class);
        return livre;
    }

    public List<CdDto> getAllCds() {
        return cdRepository.findAll().stream().map(this::convertToCdDto).collect(Collectors.toList());
    }

    public Optional<CdDto> findCdById(Long id) {
        return cdRepository.findById(id).map(this::convertToCdDto);
    }

    public Optional<Cd> saveCd(CdDto cdDto) {
        return Optional.of(cdRepository.save(convertToCd(cdDto)));
    }

    public void deleteCd(CdDto cdDto) {
        cdRepository.delete(convertToCd(cdDto));
    }

    private CdDto convertToCdDto(Cd cd) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CdDto cdDto = modelMapper.map(cd, CdDto.class);
        return cdDto;
    }

    private Cd convertToCd(CdDto cdDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Cd cd = modelMapper.map(cdDto, Cd.class);
        return cd;
    }

    public List<DvdDto> getAllDvds() {
        return dvdRepository.findAll().stream().map(this::convertToDvdDto).collect(Collectors.toList());
    }

    public Optional<DvdDto> findDvdById(Long id) {
        return dvdRepository.findById(id).map(this::convertToDvdDto);
    }

    public Optional<Dvd> saveDvd(DvdDto dvdDto) {
        return Optional.of(dvdRepository.save(convertToDvd(dvdDto)));
    }

    public void deleteDvd(DvdDto dvdDto) {
        dvdRepository.delete(convertToDvd(dvdDto));
    }

    private DvdDto convertToDvdDto(Dvd dvd) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DvdDto dvdDto = modelMapper.map(dvd, DvdDto.class);
        return dvdDto;
    }

    private Dvd convertToDvd(DvdDto dvdDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Dvd dvd = modelMapper.map(dvdDto, Dvd.class);
        return dvd;
    }

    public List<AmendeDto> getAllAmendes() {
        return amendeRepository.findAll().stream().map(this::convertToAmendeDto).collect(Collectors.toList());
    }

    public Optional<AmendeDto> findAmendeById(Long id) {
        return amendeRepository.findById(id).map(this::convertToAmendeDto);
    }

    public List<AmendeDto> getAllAmendesOfClient(Long id) {
        return amendeRepository.findAllByClientId(id).stream().map(this::convertToAmendeDto).collect(Collectors.toList());
    }

    public Optional<Amende> saveAmende(AmendeDto AmendeDto) {
        return Optional.of(amendeRepository.save(convertToAmende(AmendeDto)));
    }

    public void deleteAmende(AmendeDto AmendeDto) {
        amendeRepository.delete(convertToAmende(AmendeDto));
    }

    private AmendeDto convertToAmendeDto(Amende amende) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        AmendeDto AmendeDto = modelMapper.map(amende, AmendeDto.class);
        return AmendeDto;
    }

    private Amende convertToAmende(AmendeDto AmendeDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Amende amende = modelMapper.map(AmendeDto, Amende.class);
        return amende;
    }

    public List<EmpruntDto> getAllEmprunts() {
        return empruntRepository.findAll().stream().map(this::convertToEmpruntDto).collect(Collectors.toList());
    }

    public Optional<EmpruntDto> findEmpruntById(Long id) {
        return empruntRepository.findById(id).map(this::convertToEmpruntDto);
    }

    public List<EmpruntDto> getAllEmpruntsOfClient(Long id) {
        return empruntRepository.findAllByClientId(id).stream().map(this::convertToEmpruntDto).collect(Collectors.toList());
    }

    public Optional<Emprunt> saveEmprunt(EmpruntDto empruntDto) {
        return Optional.of(empruntRepository.save(convertToEmprunt(empruntDto)));
    }

    public void deleteEmprunt(EmpruntDto empruntDto) {
        empruntRepository.delete(convertToEmprunt(empruntDto));
    }

    public void retournerDocument(EmpruntDto empruntDto) {
        Optional<EmpruntDto> oldEmpruntDto = findEmpruntById(empruntDto.getId());
        Document doc = oldEmpruntDto.get().getDocument();
        doc.setExamplaires(doc.getExamplaires() + 1);
        documentRepository.save(doc);
        deleteEmprunt(empruntDto);
    }

    private EmpruntDto convertToEmpruntDto(Emprunt emprunt) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        EmpruntDto empruntDto = modelMapper.map(emprunt, EmpruntDto.class);
        return empruntDto;
    }

    private Emprunt convertToEmprunt(EmpruntDto empruntDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Emprunt emprunt = modelMapper.map(empruntDto, Emprunt.class);
        return emprunt;
    }

    public List<DocumentDto> findByAuteur(String auteurDocument) {
        return documentRepository.findByAuteur(auteurDocument).stream().map(this::convertToDocumentDto).collect(Collectors.toList());
    }

    public List<DocumentDto> findByAnnee(int annee) {
        return documentRepository.findByAnnee(annee).stream().map(this::convertToDocumentDto).collect(Collectors.toList());
    }

    public List<DocumentDto> findByTitre(String titreDocument) {
        return documentRepository.findByTitre(titreDocument).stream().map(this::convertToDocumentDto).collect(Collectors.toList());
    }

    public List<DocumentDto> findByCategorie(String categorie) {
        return documentRepository.findByCategorie(categorie).stream().map(this::convertToDocumentDto).collect(Collectors.toList());
    }

    private DocumentDto convertToDocumentDto(Document document) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DocumentDto documentDto = modelMapper.map(document, DocumentDto.class);
        return documentDto;
    }
}
