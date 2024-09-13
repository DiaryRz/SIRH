package com.sirh.demo.models;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;

@Document(collection = "personnels")
public class Personnel {
    
    @Id
    private String id_personnel;
    private String nom_personnel;
    private String prenom;
    private String numero_personnel;
    private Profil profil;
    private String email;
    private String mdp;
    private Arret adresse;   

    private int identifiant;  //0 tsy mandeh par défaut , 1 mandeh par défaut
    private Timestamp tele_travail;
    private Timestamp fin_conge;
        
    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
    public Timestamp getTele_travail() {
        return tele_travail;
    }
    public void setTele_travail(Timestamp tele_travail) {
        this.tele_travail = tele_travail;
    }
    public Timestamp getFin_conge() {
        return fin_conge;
    }
    public void setFin_conge(Timestamp fin_conge) {
        this.fin_conge = fin_conge;
    }
    public Arret getAdresse() {
        return adresse;
    }
    public void setAdresse(Arret adresse) {
        this.adresse = adresse;
    }
    public String getId_personnel() {
        return id_personnel;
    }
    public void setId_personnel(String id_personnel) {
        this.id_personnel = id_personnel;
    }
    public String getNom_personnel() {
        return nom_personnel;
    }
    public void setNom_personnel(String nom_personnel) {
        this.nom_personnel = nom_personnel;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNumero_personnel() {
        return numero_personnel;
    }
    public void setNumero_personnel(String numero_personnel) {
        this.numero_personnel = numero_personnel;
    }
    public Profil getProfil() {
        return profil;
    }
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    

}
