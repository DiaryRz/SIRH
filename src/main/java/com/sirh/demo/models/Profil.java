package com.sirh.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profils")
public class Profil {
    @Id
    private String id_profil;
    private String nom_profil;
    
    public String getId_profil() {
        return id_profil;
    }
    public void setId_profil(String id_profil) {
        this.id_profil = id_profil;
    }
    public String getNom_profil() {
        return nom_profil;
    }
    public void setNom_profil(String nom_profil) {
        this.nom_profil = nom_profil;
    }
    

    
  
}
