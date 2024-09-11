package com.sirh.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "arrets")
public class Arret {
    @Id
    private String id;
    private String nomArret;
    private float latitude;
    private float longitude;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomArret() {
        return nomArret;
    }
    public void setNomArret(String nomArret) {
        this.nomArret = nomArret;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    
}
