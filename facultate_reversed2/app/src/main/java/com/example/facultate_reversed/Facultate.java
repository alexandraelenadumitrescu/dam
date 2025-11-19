package com.example.facultate_reversed;

import java.io.Serializable;
import java.util.Date;

public class Facultate implements Serializable {
    Tip_invatamant tip;
    String nume;
    int cod;
    Date data;
    boolean esteDeStat;

    public Facultate(Tip_invatamant tip, String nume, int cod, Date data, boolean esteDeStat) {
        this.tip = tip;
        this.nume = nume;
        this.cod = cod;
        this.data = data;
        this.esteDeStat = esteDeStat;
    }

    @Override
    public String toString() {
        return "Facultate{" +
                "tip=" + tip +
                ", nume='" + nume + '\'' +
                ", cod=" + cod +
                ", data=" + data +
                ", esteDeStat=" + esteDeStat +
                '}';
    }

    public Tip_invatamant getTip() {
        return tip;
    }

    public void setTip(Tip_invatamant tip) {
        this.tip = tip;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEsteDeStat() {
        return esteDeStat;
    }

    public void setEsteDeStat(boolean esteDeStat) {
        this.esteDeStat = esteDeStat;
    }
}
