package exercitiul2;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {


        int Suma=0;
        float MA;
        int Vmin=Integer.MAX_VALUE;
        int Vmax=Integer.MIN_VALUE;

        int i=0;

        String nume_fisier="in.txt";
        BufferedReader flux_in;
        flux_in=new BufferedReader(new FileReader("in.txt"));

        String linie=null;
        while((linie=flux_in.readLine())!=null)
        {
            Suma=Suma+Integer.parseInt(linie);
            i++;

            if(Integer.parseInt(linie)<Vmin)
                Vmin=Integer.parseInt(linie);

            if(Integer.parseInt(linie)>Vmax)
                Vmax=Integer.parseInt(linie);

        }
        MA= (float) Suma /i;

        PrintStream flux_out=new PrintStream("out.txt");
        flux_out.println("Suma este: "+Suma);
        flux_out.println("media aritmetica este: "+MA);
        flux_out.println("valoarea minima este: "+Vmin);
        flux_out.println("valoarea maxima este: "+Vmax);

        System.out.println("Suma este: "+Suma);
        System.out.println("media aritmetica este: "+MA);
        System.out.println("valoarea minim este: "+Vmin);
        System.out.println("valoarea maxima este: "+Vmax);
    }
}
