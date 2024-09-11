package com.sirh.demo.models;


import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teletravails")
public class Teletravail {
    @Id
    private String id_teletravail;
    @DBRef
    private Personnel personnel;
    private Timestamp date_debut;
    private Timestamp date_fin;
  

    public Teletravail() {
    }

    public String getId_teletravail() {
        return id_teletravail;
    }

    public void setId_teletravail(String id_teletravail) {
        this.id_teletravail = id_teletravail;
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

    public Teletravail(String id_teletravail, Personnel personnel, Timestamp date_debut, Timestamp date_fin) {
        this.id_teletravail = id_teletravail;
        this.personnel = personnel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

}

