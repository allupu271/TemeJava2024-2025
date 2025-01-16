import java.io.Serializable;

public class Copiatoare extends Echipament implements Serializable
{
    private int p_ton;
    private Format format;

    public Copiatoare(String nume, int nrInv, int pret, String zonaMag,String stare,int p_ton,Format format) {
        super(nume, nrInv, pret, zonaMag,stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public Format getFormat()
    {
        return format;
    }

    public void setFormat(Format format)
    {
        this.format = format;
    }

    public String toString()
    {
        return super.toString() + " " + p_ton + " " + format;
    }
}
