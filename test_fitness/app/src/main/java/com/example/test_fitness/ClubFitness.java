package com.example.test_fitness;

import java.io.Serial;
import java.io.Serializable;

public class ClubFitness implements Serializable {
    float pret;
    int nrSali;
    int nrAparate;
    int nrAntrenori;
    boolean esteNonStop;

    @Override
    public String toString() {
        return "ClubFitness{" +
                "pret=" + pret +
                ", nrSali=" + nrSali +
                ", nrAparate=" + nrAparate +
                ", nrAntrenori=" + nrAntrenori +
                ", esteNonStop=" + esteNonStop +
                '}';
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getNrSali() {
        return nrSali;
    }

    public void setNrSali(int nrSali) {
        this.nrSali = nrSali;
    }

    public int getNrAparate() {
        return nrAparate;
    }

    public void setNrAparate(int nrAparate) {
        this.nrAparate = nrAparate;
    }

    public int getNrAntrenori() {
        return nrAntrenori;
    }

    public void setNrAntrenori(int nrAntrenori) {
        this.nrAntrenori = nrAntrenori;
    }

    public boolean isEsteNonStop() {
        return esteNonStop;
    }

    public void setEsteNonStop(boolean esteNonStop) {
        this.esteNonStop = esteNonStop;
    }

    public ClubFitness(float pret, int nrSali, int nrAparate, int nrAntrenori, boolean esteNonStop) {
        this.pret = pret;
        this.nrSali = nrSali;
        this.nrAparate = nrAparate;
        this.nrAntrenori = nrAntrenori;
        this.esteNonStop = esteNonStop;
    }
}
