package domain;

public class Film {
    private String titlu;
    private int durata;
    private Gen gen;

    public Film(String titlu, int durata, Gen gen) {
        this.titlu = titlu;
        this.durata = durata;
        this.gen = gen;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titlu='" + titlu + '\'' +
                ", durata=" + durata +
                ", gen=" + gen +
                '}';
    }
}
