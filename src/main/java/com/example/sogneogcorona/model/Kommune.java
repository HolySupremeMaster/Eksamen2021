package com.example.sogneogcorona.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Kommune")
public class Kommune {
    @Id
    private int kommuneID;

    private String navn;

    public Kommune() {
    }

    public int getKommuneID() {
        return kommuneID;
    }

    public void setKommuneID(int kommuneID) {
        this.kommuneID = kommuneID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return
                kommuneID +
                 navn;
    }
}
