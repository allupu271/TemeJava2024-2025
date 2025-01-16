import java.io.Serializable;

public class Echipament implements Serializable
{
    private String nume;
    private int nr_inv;
    private int pret;
    private String zona_mag;
    private String stare;

    public Echipament(String nume, int nrInv, int pret, String zonaMag, String stare)
    {
        this.nume = nume;
        nr_inv = nrInv;
        this.pret = pret;
        zona_mag = zonaMag;
        this.stare = stare;
    }

    public String getNume()
    {
        return nume;
    }

    public String getStare()
    {
        return stare;
    }

    public void setStare(String stare)
    {
        this.stare = stare;
    }


    @Override
    public String toString()
    {
        return nume + " " + nr_inv + " " + pret + " " + zona_mag+" "+stare;
    }
}
