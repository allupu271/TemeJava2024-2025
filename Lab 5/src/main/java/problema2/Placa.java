package problema2;

public class Placa
{
    private String descriere;
    private int lungime;
    private int latime;
    private orientare orientare;
    private boolean[] canturi;
    private int nr_bucati;

    public Placa(){}

    public Placa(String descriere, int lungime, problema2.orientare orientare, int latime, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.orientare = orientare;
        this.latime = latime;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
    }


    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public problema2.orientare getOrientare() {
        return this.orientare;
    }

    public boolean[] getCanturi() {
        return this.canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }
}
