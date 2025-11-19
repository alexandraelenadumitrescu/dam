package com.example.salafitness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ClubFitness implements Serializable {
    private String nume;
    private String adresa;
    private float pret;
    private Date dataDeschidere;
    private  boolean esteNonStop;


    @Override
    public String toString() {
        return "ClubFitness{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", pret=" + pret +
                ", dataDeschidere=" + dataDeschidere +
                ", esteNonStop=" + esteNonStop +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Date getDataDeschidere() {
        return dataDeschidere;
    }

    public void setDataDeschidere(Date dataDeschidere) {
        this.dataDeschidere = dataDeschidere;
    }

    public boolean isEsteNonStop() {
        return esteNonStop;
    }

    public void setEsteNonStop(boolean esteNonStop) {
        this.esteNonStop = esteNonStop;
    }

    public ClubFitness(String nume, String adresa, float pret, Date dataDeschidere, boolean esteNonStop) {
        this.nume = nume;
        this.adresa = adresa;
        this.pret = pret;
        this.dataDeschidere = dataDeschidere;
        this.esteNonStop = esteNonStop;
    }
}
