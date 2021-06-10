package com.example.sogneogcorona.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Sogne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sogneKode;
    private String navn;
    private String kommune;
    private double smittetype;
    private Date nedlykningStart;


    public Sogne() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public double getSmittetype() {
        return smittetype;
    }

    public void setSmittetype(double smittetype) {
        this.smittetype = smittetype;
    }

    public Date getNedlykningStart() {
        return nedlykningStart;
    }

    public void setNedlykningStart(Date nedlykningStart) {
        this.nedlykningStart = nedlykningStart;
    }

    @Override
    public String toString() {
        return "Sogne{" +
                "id=" + id +
                ", sogneKode=" + sogneKode +
                ", navn='" + navn + '\'' +
                ", kommune='" + kommune + '\'' +
                ", smittetype=" + smittetype +
                ", nedlykningStart=" + nedlykningStart +
                '}';
    }
}
