package com.example.final2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cursa {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int distanta;
    private String destinatie;
    @ColumnInfo(defaultValue = "false")
    private boolean manual;

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", distanta=" + distanta +
                ", destinatie='" + destinatie + '\'' +
                ", manual=" + manual +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistanta() {
        return distanta;
    }

    public void setDistanta(int distanta) {
        this.distanta = distanta;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public Cursa(int id, int distanta, String destinatie, boolean manual) {
        this.id = id;
        this.distanta = distanta;
        this.destinatie = destinatie;
        this.manual = manual;
    }
}
