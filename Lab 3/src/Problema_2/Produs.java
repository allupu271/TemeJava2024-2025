package Problema_2;

import java.time.LocalDate;

public class Produs {
    private String nume;
    private float pret;
    private int bucat;
    private LocalDate dataExpirare;
    public static float incasari;

    Produs(String nume, float pret, int bucat, LocalDate dataExpirare) {
        this.nume = nume;
        this.pret = pret;
        this.bucat = bucat;
        this.dataExpirare = dataExpirare;
    }

    public String getNume()
    {
        return nume;
    }

    public float pert()
    {
        return pret;
    }

    public int getBucat()
    {
        return bucat;
    }

    public void setBucati(int val)
    {
        this.bucat = bucat - val;
    }

    public LocalDate getDataExpirare()
    {
        return dataExpirare;
    }

    public float getIncasari()
    {
        return incasari;
    }

    public void setIncasari(float val)
    {
        incasari = val;
    }

    @Override
    public String toString() {
        return nume + " " + pret + " " + bucat + " " + dataExpirare;
    }
}
