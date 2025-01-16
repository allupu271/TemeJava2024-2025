import java.io.Serializable;

public class Imprimante extends Echipament implements Serializable
{
    private int pagini_ppm;
    private String rezolutie;
    private int p_car;
    private Tiparire tiparire;

    public Imprimante(String nume, int nrInv, int pret, String zonaMag,String stare, int paginiPpm, String rezolutie, int pCar, Tiparire tiparire) {
        super(nume, nrInv, pret, zonaMag,stare);
        this.pagini_ppm = paginiPpm;
        this.rezolutie = rezolutie;
        this.p_car = pCar;
        this.tiparire = tiparire;
    }


    public void setRezolutie(String rezolutie)
    {
        this.rezolutie = rezolutie;
    }

    public String toString()
    {
        return super.toString() +" "+ pagini_ppm + " " + rezolutie + " " + p_car + " " + tiparire;
    }
}
