package com.sirh.demo.models;

public class Retour {
    String erreur;
    String message;
    Object data;

    public String getErreur() {
        return erreur;
    }

    public void setErreur(String erreur) {
        this.erreur =erreur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Retour(String erreur, String message, Object data) {
        this.setErreur(erreur);
        this.setMessage(message);
        this.setData(data);
    }

    public Retour(Object data)  {
        try {
            this.setData(data);
            this.setErreur("aucune erreur"); 
            this.setMessage("Réussi");
        }catch (Exception e) {
            this.setData(null);
            this.setErreur( e.getMessage());
            this.setMessage("Echoue"); 
        }
    }

    
}
