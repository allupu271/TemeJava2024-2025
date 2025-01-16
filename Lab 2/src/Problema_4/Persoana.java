package Problema_4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoana
{
    private String nume;
    private String CNP;

    Persoana(String nume, String CNP)
    {
        this.nume = nume;
        this.CNP = CNP;
    }

//32

    public int getVarsa()
    {
        int varsta,zi,luna,an;

        an = Integer.parseInt(CNP.substring(1,3));
        luna = Integer.parseInt(CNP.substring(3,5));
        zi = Integer.parseInt(CNP.substring(5,7));

        switch(CNP.charAt(0))
        {
            case '1' ,'2' -> an = 19*100+an;
            case '5' ,'6' -> an = 20*100+an;
        }

        LocalDate date_nastre = LocalDate.of(an,luna,zi);
        LocalDate date_curenta = LocalDate.now();

        varsta = (int) ChronoUnit.YEARS.between(date_nastre,date_curenta);

        return varsta;
    }
}
