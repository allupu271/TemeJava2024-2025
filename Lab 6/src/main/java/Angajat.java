import java.time.LocalDate;

public class Angajat
{
    private String nume;
    private String postul;
    private LocalDate data_angajare;
    public float salariul;

    public Angajat() {};

    public Angajat(String nume, String postul, LocalDate dataAngajare, float salariul)
    {
        this.nume = nume;
        this.postul = postul;
        data_angajare = dataAngajare;
        this.salariul = salariul;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPostul() {
        return postul;
    }

    public void setPostul(String postul) {
        this.postul = postul;
    }

    public LocalDate getData_angajare() {
        return data_angajare;
    }

    public void setData_angajare(LocalDate data_angajare) {
        this.data_angajare = data_angajare;
    }

    public float getSalariul()
    {
        return salariul;
    }

    public void setSalariul(float salariul)
    {
        this.salariul = salariul;
    }

    public String toString()
    {
        return nume + " , " + postul + " , " + data_angajare + " , " + salariul;
    }

}
