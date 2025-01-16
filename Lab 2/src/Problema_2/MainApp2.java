package Problema_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Stream;



public class MainApp2
{

    public static void main(String[] args) throws FileNotFoundException
    {
        String[] cantec = new String[80];
        int nr=0,i,val_cuvite,val_vocale;
        String litere;

        Scanner cin = new Scanner(new File("cantec_in.txt"));
        PrintStream flux_out = new PrintStream ("cantec_out.txt");

        while (cin.hasNextLine())
        {
            cantec[nr] = cin.nextLine();
            nr++;
        }


        Scanner cin2= new Scanner(System.in);
        System.out.print("Introduce grupul de litere : ");
        litere = cin2.nextLine();

        Random numar = new Random();

        for(i=0;i<cantec.length;i++)
        {
            if(!Objects.equals(cantec[i], ""))
            {
                Vers nume=new Vers(cantec[i]);
                val_cuvite= nume.Nr_cuvite();
                val_vocale= nume.Nr_vocale();
                if(nume.Verficare(litere))
                {
                    if(numar.nextDouble()<0.1)
                    {
                        flux_out.println(val_cuvite + " " + val_vocale + " " + nume.versMajuscule() +"*");
                    }
                    else
                    {
                        flux_out.println(val_cuvite + " " + val_vocale + " " + nume.getVers());
                    }
                }
                else
                {
                    flux_out.println(val_cuvite + " " + val_vocale + " " + nume.getVers());
                }
            }
            else
            {
                flux_out.println();
            }
        }

        flux_out.close();

    }

}
