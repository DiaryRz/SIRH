package com.sirh.demo.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.sql.Timestamp;

@Document(collection = "conges")
public class Conge {
    @Id
    private String id;
    
    @DBRef
    private Personnel personnel;
    
    private Timestamp date_debut;
    private Timestamp date_fin;
    private String raison;

    public Conge() {}

    public Conge(Personnel personnel, Timestamp date_debut, Timestamp date_fin, String raison) {
        this.personnel = personnel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.raison = raison;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
}
