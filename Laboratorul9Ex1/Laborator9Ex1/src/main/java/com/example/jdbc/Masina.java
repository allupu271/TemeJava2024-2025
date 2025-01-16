package com.example.jdbc;

public class Masina {
    private String NrInm;
    private String Marca;
    private int AnFabr;
    private String Culoare;
    private long NrKm;

    public Masina() {}
    public Masina(String NrInm, String Marca, int AnFbr, String Culoare, long NrKm) {
        this.NrInm = NrInm;
        this.Marca = Marca;
        this.AnFabr = AnFabr;
        this.Culoare = Culoare;
        this.NrKm = NrKm;
    }

    public String getNrInmatriculare() {
        return NrInm;
    }

    public void setNr_inmatriculare(String NrInm) {
        this.NrInm = NrInm;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = Marca;
    }

    public String getCuloare() {
        return Culoare;
    }

    public void setCuloare(String culoare) {
        this.Culoare = Culoare;
    }

    public int getAnulFabricatiei() {
        return AnFabr;
    }

    public void setAnul_fabricatiei(int AnFabr) {
        this.AnFabr = AnFabr;
    }

    public long getNrKm() {
        return NrKm;
    }

    public void setNr_km(long NrKm) {
        this.NrKm = NrKm;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + NrInm + '\'' +
                ", marca='" + Marca + '\'' +
                ", anul_fabricatiei=" + AnFabr +
                ", culoare='" + Culoare + '\'' +
                ", nr_km=" + NrKm +
                '}';
    }

}
