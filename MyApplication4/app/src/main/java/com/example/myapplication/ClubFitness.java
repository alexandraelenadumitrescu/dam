package com.example.myapplication;

import java.io.Serializable;
import java.util.Date;

public class ClubFitness implements Serializable {
    private float price;
    private String nume;
    private Date dataDeschidere;
    private boolean esteNonStop;
    private String adresa;

    @Override
    public String toString() {
        return "ClubFitness{" +
                "price=" + price +
                ", nume='" + nume + '\'' +
                ", dataDeschidere=" + dataDeschidere +
                ", esteNonStop=" + esteNonStop +
                ", adresa='" + adresa + '\'' +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public ClubFitness(float price, String nume, Date dataDeschidere, boolean esteNonStop, String adresa) {
        this.price = price;
        this.nume = nume;
        this.dataDeschidere = dataDeschidere;
        this.esteNonStop = esteNonStop;
        this.adresa = adresa;
    }
}
