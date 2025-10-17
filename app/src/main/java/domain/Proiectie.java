package domain;

import android.icu.text.RelativeDateTimeFormatter;

import java.util.Date;

public class Proiectie {
    private Film film;
    private int sala;
    private Date data;
    private int locuriTotale;
    private int locuriRezervate=0;

    public Proiectie(Film film, int sala, Date data, int locuriTotale, int locuriRezervate) {
        this.film = film;
        this.sala = sala;
        this.data = data;
        this.locuriTotale = locuriTotale;
        this.locuriRezervate = locuriRezervate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getLocuriTotale() {
        return locuriTotale;
    }

    public void setLocuriTotale(int locuriTotale) {
        this.locuriTotale = locuriTotale;
    }

    public int getLocuriRezervate() {
        return locuriRezervate;
    }

    public void setLocuriRezervate(int locuriRezervate) {
        this.locuriRezervate = locuriRezervate;
    }

    @Override
    public String toString() {
        return "Proiectie{" +
                "film=" + film +
                ", sala=" + sala +
                ", data=" + data +
                ", locuriTotale=" + locuriTotale +
                ", locuriRezervate=" + locuriRezervate +
                '}';
    }
}
