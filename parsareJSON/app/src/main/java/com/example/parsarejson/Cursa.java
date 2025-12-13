package com.example.parsarejson;


import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Cursa {
    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name  ="destinatie")
    private String destinatie;
    @ColumnInfo(name  ="distanta")
    private int distanta;
    @ColumnInfo(name  ="manual")
    private boolean manual;


    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", destinatie='" + destinatie + '\'' +
                ", distanta=" + distanta +
                ", manual=" + manual +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getDistanta() {
        return distanta;
    }

    public void setDistanta(int distanta) {
        this.distanta = distanta;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public Cursa(int id, String destinatie, int distanta, boolean manual) {
        this.id=id;
        this.destinatie = destinatie;
        this.distanta = distanta;
        this.manual = manual;
    }
}
