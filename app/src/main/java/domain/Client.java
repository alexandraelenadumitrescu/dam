package domain;

import java.sql.Date;

public class Client {
    private String nume;
    private String prenume;
    private Date ziDeNastere;
    private TipClient tipClient;

    public Client(String nume, String prenume, Date ziDeNastere, TipClient tipClient) {
        this.nume = nume;
        this.prenume = prenume;
        this.ziDeNastere = ziDeNastere;
        this.tipClient = tipClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getZiDeNastere() {
        return ziDeNastere;
    }

    public void setZiDeNastere(Date ziDeNastere) {
        this.ziDeNastere = ziDeNastere;
    }

    public TipClient getTipClient() {
        return tipClient;
    }

    public void setTipClient(TipClient tipClient) {
        this.tipClient = tipClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", ziDeNastere=" + ziDeNastere +
                ", tipClient=" + tipClient +
                '}';
    }
}
