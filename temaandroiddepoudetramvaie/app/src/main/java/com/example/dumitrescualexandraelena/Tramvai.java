package com.example.dumitrescualexandraelena;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Tramvai implements Serializable{
    private String producator;
    private String nrInmatriculare;
    private int nrLocuri;
    private Date dataInmatriculare;
    private boolean esteFunctional;

    protected Tramvai(Parcel in) {
        producator = in.readString();
        nrInmatriculare = in.readString();
        nrLocuri = in.readInt();
        esteFunctional = in.readByte() != 0;
    }



    @Override
    public String toString() {
        return "com.example.dumitrescualexandraelena.Tramvai{" +
                "producator='" + producator + '\'' +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                ", nrLocuri=" + nrLocuri +
                ", dataInmatriculare=" + dataInmatriculare +
                ", esteFunctional=" + esteFunctional +
                '}';
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public Date getDataInmatriculare() {
        return dataInmatriculare;
    }

    public void setDataInmatriculare(Date dataInmatriculare) {
        this.dataInmatriculare = dataInmatriculare;
    }

    public boolean isEsteFunctional() {
        return esteFunctional;
    }

    public void setEsteFunctional(boolean esteFunctional) {
        this.esteFunctional = esteFunctional;
    }

    public Tramvai(String producator, String nrInmatriculare, int nrLocuri, Date dataInmatriculare, boolean esteFunctional) {
        this.producator = producator;
        this.nrInmatriculare = nrInmatriculare;
        this.nrLocuri = nrLocuri;
        this.dataInmatriculare = dataInmatriculare;
        this.esteFunctional = esteFunctional;
    }


}
