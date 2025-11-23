package com.example.customadapteri.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String nume;
    private Date dataNastere;
    private int nrCredite;

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", dataNastere=" + dataNastere +
                ", nrCredite=" + nrCredite +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public int getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public Student(String nume, Date dataNastere, int nrCredite) {
        this.nume = nume;
        this.dataNastere = dataNastere;
        this.nrCredite = nrCredite;
    }
}
