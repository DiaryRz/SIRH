package com.sirh.demo.models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teletravails")
public class Teletravail {
    @Id
    private String id_teletravail;
    @DBRef
    private Personnel personnel;
    private Date date_debut;
    private Date date_fin;
  

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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Teletravail(String id_teletravail, Personnel personnel, Date date_debut, Date date_fin) {
        this.id_teletravail = id_teletravail;
        this.personnel = personnel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

}

