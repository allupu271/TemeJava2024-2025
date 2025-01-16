import java.io.Serializable;

public class Sisteme_de_calcul extends Echipament implements Serializable
{
    private String tip_mon;
    private String vit_proc;
    private int c_hdd;
    private Sistem sistem;

    public Sisteme_de_calcul(String nume, int nrInv, int pret, String zonaMag,String stare,String tip_mon,String vit_proc,int c_hdd,Sistem sistem) {
        super(nume, nrInv, pret, zonaMag,stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    public Sistem getSistem()
    {
        return sistem;
    }

    public void setSistem(Sistem sistem)
    {
        this.sistem = sistem;
    }


    public String toString()
    {
        return super.toString()+" "+tip_mon+" "+vit_proc+" "+c_hdd+" "+sistem;
    }
}
