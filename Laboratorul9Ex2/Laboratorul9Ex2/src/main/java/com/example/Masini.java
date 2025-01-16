package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masiniJPA")
public class Masini {
    @Id
    private String NrInm;
    private String Marca;
    private int AnFabr;
    private String Culoare;
    private long NrKm;

    public Masini() {}
    public Masini(String NrInm, String Marca, int AnFabr, String Culoare, long NrKm) {
        this.NrInm = NrInm;
        this.Marca = Marca;
        this.AnFabr = AnFabr;
        this.Culoare = Culoare;
        this.NrKm = NrKm;
    }

    public String getNrInmatriculare() {
        return NrInm;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.NrInm = NrInm;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getCuloare() {
        return Culoare;
    }

    public void setCuloare(String Culoare) {
        this.Culoare = Culoare;
    }

    public int getAnulFabricatiei() {
        return AnFabr;
    }

    public void setAnFabr(int AnFabr) {
        this.AnFabr = AnFabr;
    }

    public long getNrKm() {
        return NrKm;
    }

    public void setNrKm(long nrKm) {
        this.NrKm = nrKm;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + NrInm + '\'' +
                ", Marca='" + Marca + '\'' +
                ", AnFabr=" + AnFabr +
                ", Culoare='" + Culoare + '\'' +
                ", NrKm=" + NrKm +
                '}';
    }

}
