package com.example.sogneogcorona.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sogne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sogneKode;
    private String navn;
    @OneToOne
    @JoinColumn(name = "kommune_id", nullable = false)
    private Kommune kommune;
    private double smittetryk;
    private Date nedlukningStart;


    public Sogne() {
    }

    public Sogne(int sogneKode, String navn, Kommune kommune, double smittetryk, Date nedlukningStart) {
        this.sogneKode = sogneKode;
        this.navn = navn;
        this.kommune = kommune;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
    }
    public Sogne(int id, int sogneKode, String navn, double smittetryk, Date nedlukningStart, Kommune kommune) {
        this.id = id;
        this.sogneKode = sogneKode;
        this.navn = navn;
        this.smittetryk = smittetryk;
        this.nedlukningStart = nedlukningStart;
        this.kommune = kommune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSogneKode() {
        return sogneKode;
    }

    public void setSogneKode(int sogneKode) {
        this.sogneKode = sogneKode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Kommune getKommune() {
        return kommune;
    }

    public void setKommune(Kommune kommune) {
        this.kommune = kommune;
    }

    public double getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(double smittetryk) {
        this.smittetryk = smittetryk;
    }

    public Date getNedlukningStart() {
        return nedlukningStart;
    }

    public void setNedlukningStart(Date nedlukningStart) {
        this.nedlukningStart = nedlukningStart;
    }

    @Override
    public String toString() {
        return "Sogne{" +
                "id=" + id +
                ", sogneKode=" + sogneKode +
                ", navn='" + navn + '\'' +
                ", kommune=" + kommune +
                ", smittetryk=" + smittetryk +
                ", nedlukningStart=" + nedlukningStart +
                '}';
    }
}