package Problema2;

public class Chitara extends InstrumentMuzical
{
    private TipChitara tipChitara;
    private int nrCorzi;

    public Chitara(){
        super();
    }

    public Chitara(String producator, double pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }

    @Override
    public void Afisare()
    {
        System.out.println(getProducator()+" "+getPret()+" "+tipChitara+" "+nrCorzi);
    }
}
