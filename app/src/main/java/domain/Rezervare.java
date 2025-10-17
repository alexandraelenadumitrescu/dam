package domain;

public class Rezervare {
    private Client client;
    private Proiectie proiectie;
    private int nrLocuri;

    @Override
    public String toString() {
        return "Rezervare{" +
                "client=" + client +
                ", proiectie=" + proiectie +
                ", nrLocuri=" + nrLocuri +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Proiectie getProiectie() {
        return proiectie;
    }

    public void setProiectie(Proiectie proiectie) {
        this.proiectie = proiectie;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public Rezervare(Client client, Proiectie proiectie, int nrLocuri) {
        this.client = client;
        this.proiectie = proiectie;
        this.nrLocuri = nrLocuri;
    }
}
