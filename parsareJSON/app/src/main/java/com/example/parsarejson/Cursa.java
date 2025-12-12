package com.example.parsarejson;

public class Cursa {
    private int id;
    private String destinatie;
    private int distanta;
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
        this.id = id;
        this.destinatie = destinatie;
        this.distanta = distanta;
        this.manual = manual;
    }
}
