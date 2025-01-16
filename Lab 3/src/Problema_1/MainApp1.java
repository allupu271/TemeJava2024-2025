package Problema_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int nr=0,i,a,b,c;
        String date_fiser=new String();
        List<Parabola> list =new ArrayList<Parabola>();

        Scanner fis =new Scanner(new File("in.txt"));

        while (fis.hasNextLine())
        {

            date_fiser=fis.nextLine();
            String[] date=date_fiser.split(" ");

            a=Integer.parseInt(date[0]);
            b=Integer.parseInt(date[1]);
            c=Integer.parseInt(date[2]);

            list.add(new Parabola(a,b,c));
        }

        for(Parabola p:list)
        {
            System.out.println(p);
            double[] varf=p.varf();
            System.out.println(varf[0] + " " + varf[1]);
        }
    }
}
