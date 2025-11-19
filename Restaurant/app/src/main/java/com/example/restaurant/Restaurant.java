package com.example.restaurant;

import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {
    private int nrScaune;
    private String nume;
    private boolean esteVegan;
    private Date dataDeschidere;
    private String adresa;

    @Override
    public String toString() {
        return "Restaurant{" +
                "nrScaune=" + nrScaune +
                ", nume='" + nume + '\'' +
                ", esteVegan=" + esteVegan +
                ", dataDeschidere=" + dataDeschidere +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public int getNrScaune() {
        return nrScaune;
    }

    public void setNrScaune(int nrScaune) {
        this.nrScaune = nrScaune;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean isEsteVegan() {
        return esteVegan;
    }

    public void setEsteVegan(boolean esteVegan) {
        this.esteVegan = esteVegan;
    }

    public Date getDataDeschidere() {
        return dataDeschidere;
    }

    public void setDataDeschidere(Date dataDeschidere) {
        this.dataDeschidere = dataDeschidere;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Restaurant(int nrScaune, String nume, boolean esteVegan, Date dataDeschidere, String adresa) {
        this.nrScaune = nrScaune;
        this.nume = nume;
        this.esteVegan = esteVegan;
        this.dataDeschidere = dataDeschidere;
        this.adresa = adresa;
    }
}
