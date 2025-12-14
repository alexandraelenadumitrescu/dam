package com.example.curse;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "curse")
public class Cursa {
    @PrimaryKey(autoGenerate = true)

    private int id;
    @ColumnInfo()
    private boolean manual;
    @ColumnInfo()
    private String destinatie;
    @ColumnInfo()
    private int distanta;

    public Cursa(int id, boolean manual, String destinatie, int distanta) {
        this.id = id;
        this.manual = manual;
        this.destinatie = destinatie;
        this.distanta = distanta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
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

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", manual=" + manual +
                ", destinatie='" + destinatie + '\'' +
                ", distanta=" + distanta +
                '}';
    }
}
