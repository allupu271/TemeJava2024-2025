package problema2;

import java.util.List;

public class Mobilier
{
    private String nume;
    private List<Placa> placi;

    public Mobilier(){}

    public Mobilier(List<Placa> placi, String nume) {
        this.placi = placi;
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return this.placi;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }
}
