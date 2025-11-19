package com.example.test_recap;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class ClubSportiv implements Serializable {
    private Date dataAniversara;
    private String nume;
    private String adresa;
    private int nrSportivi;
    private int nrFacilitati;

    @Override
    public String toString() {
        return "ClubSportiv{" +
                "dataAniversara=" + dataAniversara +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", nrSportivi=" + nrSportivi +
                ", nrFacilitati=" + nrFacilitati +
                '}';
    }

    public Date getDataAniversara() {
        return dataAniversara;
    }

    public void setDataAniversara(Date dataAniversara) {
        this.dataAniversara = dataAniversara;
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

    public int getNrSportivi() {
        return nrSportivi;
    }

    public void setNrSportivi(int nrSportivi) {
        this.nrSportivi = nrSportivi;
    }

    public int getNrFacilitati() {
        return nrFacilitati;
    }

    public void setNrFacilitati(int nrFacilitati) {
        this.nrFacilitati = nrFacilitati;
    }

    public ClubSportiv(Date dataAniversara, String nume, String adresa, int nrSportivi, int nrFacilitati) {
        this.dataAniversara = dataAniversara;
        this.nume = nume;
        this.adresa = adresa;
        this.nrSportivi = nrSportivi;
        this.nrFacilitati = nrFacilitati;
    }
}
