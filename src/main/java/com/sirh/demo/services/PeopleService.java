package com.sirh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sirh.demo.models.Personnel;
import com.sirh.demo.models.Retour;
import com.sirh.demo.repositories.PersonnelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleService {

    @Autowired
    private PersonnelRepository personnelRepository;


    public Retour selectPeople(){
        return new Retour(personnelRepository.findAll());
    }
    @Transactional
    public Retour modifierPersonnel(String idPersonnel, Personnel personnelModifie) {
        try {
            Personnel personnelExistant = personnelRepository.findById(idPersonnel)
                .orElseThrow(() -> new RuntimeException("Aucun personnel trouvé avec l'ID : " + idPersonnel));
            
            // Mise à jour des champs modifiables
            personnelExistant.setNom_personnel(personnelModifie.getNom_personnel());
            personnelExistant.setPrenom(personnelModifie.getPrenom());
            personnelExistant.setEmail(personnelModifie.getEmail());
            personnelExistant.setNumero_personnel(personnelModifie.getNumero_personnel());
            personnelExistant.setAdresse(personnelModifie.getAdresse());
            
            // Mise à jour de la date de modification
            
            Personnel personnelMisAJour = personnelRepository.save(personnelExistant);
            return new Retour(personnelMisAJour);
        } catch (Exception e) {
            return new Retour("Erreur lors de la modification du personnel : " + e.getMessage());
        }
    }
    public Retour trouverTousLesChauffeurs() {
        try {
            List<Personnel> chauffeurs = personnelRepository.findAll().stream()
                .filter(personnel -> personnel.getProfil() != null && "chauffeur".equalsIgnoreCase(personnel.getProfil().getNom_profil()))
                .collect(Collectors.toList());
            return new Retour(chauffeurs);
        } catch (Exception e) {
            return new Retour("Erreur lors de la recherche des chauffeurs : " + e.getMessage());
        }
    }
    public Retour trouverTousLesPersonnels() {
        try {
            List<Personnel> personnels = personnelRepository.findAll().stream()
                .filter(personnel -> personnel.getProfil() != null && "personnel".equalsIgnoreCase(personnel.getProfil().getNom_profil()))
                .collect(Collectors.toList());
            return new Retour(personnels);
        } catch (Exception e) {
            return new Retour("Erreur lors de la recherche des personnels : " + e.getMessage());
        }
    }
    public Retour trouverChauffeurParId(String idChauffeur) {
        try {
            Personnel chauffeur = personnelRepository.findById(idChauffeur)
                .filter(personnel -> personnel.getProfil() != null && "chauffeur".equalsIgnoreCase(personnel.getProfil().getNom_profil()))
                .orElseThrow(() -> new RuntimeException("Aucun chauffeur trouvé avec l'ID : " + idChauffeur));
            return new Retour(chauffeur);
        } catch (Exception e) {
            return new Retour("Erreur lors de la recherche du chauffeur : " + e.getMessage());
        }
    }

    public Retour trouverPersonnelParId(String idPersonnel) {
        try {
            Personnel personnel = personnelRepository.findById(idPersonnel)
                .filter(p -> p.getProfil() != null && "personnel".equalsIgnoreCase(p.getProfil().getNom_profil()))
                .orElseThrow(() -> new RuntimeException("Aucun personnel trouvé avec l'ID : " + idPersonnel));
            return new Retour(personnel);
        } catch (Exception e) {
            return new Retour("Erreur lors de la recherche du personnel : " + e.getMessage());
        }
    }


}