package Problema_1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class MainApp
{
    public static void main(String[] args) throws IOException {
        String[] judete =new String[41];
        int nr=0,i;

        Scanner sc = new Scanner(new File("judete_in.txt"));

        while (sc.hasNextLine())
        {
            String judet = sc.nextLine();
            judete[nr]=judet;
            nr++;
        }

        Arrays.sort(judete); // daca vreu sa folosesc acesta line de cod String[] trebuie sa nu aiba null ca valoare

        Scanner val =new Scanner(System.in);
        System.out.print("Judet : ");
        String string = val.nextLine();

        for(i=0;i<judete.length;i++)
        {
            if(judete[i].equals(string))
                System.out.println("Se afla pe pozitia : "+ i);
        }

        //System.out.println(Arrays.toString(judete));
    }
}
