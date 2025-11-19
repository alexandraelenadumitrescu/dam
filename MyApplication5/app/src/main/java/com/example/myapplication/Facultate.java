package com.example.myapplication;

import java.io.Serializable;
import java.util.Date;

public class Facultate implements Serializable {
    private int cod;
    private String nume;
    private String adresa;
    private Date date;
    private boolean esteDeStat;

    @Override
    public String toString() {
        return "Facultate{" +
                "cod=" + cod +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", date=" + date +
                ", esteDeStat=" + esteDeStat +
                '}';
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isEsteDeStat() {
        return esteDeStat;
    }

    public void setEsteDeStat(boolean esteDeStat) {
        this.esteDeStat = esteDeStat;
    }

    public Facultate(int cod, String nume, String adresa, Date date, boolean esteDeStat) {
        this.cod = cod;
        this.nume = nume;
        this.adresa = adresa;
        this.date = date;
        this.esteDeStat = esteDeStat;
    }
}
