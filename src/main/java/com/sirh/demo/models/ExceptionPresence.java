package com.sirh.demo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exceptionpresences")
public class ExceptionPresence {
    @Id
    private String id_exception_presence;
    
    @DBRef
    private Personnel personnel;
    private Date date;
    private int identifiant; //absent sa present. tsy ho avy 0 , hiakatra 1
    private int matin_ou_soir; //0 : matin , 1 : soir

    public String getId_exception_resence() {
        return id_exception_presence;
    }
    public void setid_exception_presence(String id_exception_presence) {
        this.id_exception_presence = id_exception_presence;
    }
    public Personnel getPersonnel() {
        return personnel;
    }
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
    public int getMatin_ou_soir() {
        return matin_ou_soir;
    }
    public void setMatin_ou_soir(int matin_ou_soir) {
        this.matin_ou_soir = matin_ou_soir;
    }

    
}

