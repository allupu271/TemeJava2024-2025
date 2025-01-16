package Problema_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp3
{
    public static void main(String[] args) throws FileNotFoundException
    {

        int val=0 , pozitie=0 , cate=0 ;
        String raspuns,line="",insert="";
        Scanner sc = new Scanner(System.in);
        System.out.print("Citirea se va face de la tastatura : ");
        raspuns = sc.nextLine();

        if (raspuns.equals("Da"))
        {
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Introduceti o propozitie : ");
            line = sc2.nextLine();
            StringBuffer sb_line = new StringBuffer(line);
            System.out.print("Introduceti ce vreti sa inserati : ");
            insert = sc2.nextLine();
            System.out.print("Pe ce pozitie vrei sa inserati : ");
            val = sc2.nextInt();

            if(val >= 0 && val <= sb_line.length())
            {
                sb_line.insert(val, insert+" ");

            }
            else
            {
                System.out.println("Nu se poate insera pe acea pozitie.");
            }

            System.out.println("Dupa ce sa facut inserarea : "+ sb_line.toString());

            System.out.print("Introduceti pozitia de incepere a stergei : ");
            pozitie = sc.nextInt();
            System.out.print("Cate litere doriti sa stergei : ");
            cate = sc.nextInt();

            if(cate >= 0 && pozitie+cate <= sb_line.length())
            {
                sb_line.delete(pozitie, pozitie+cate);
            }
            else
            {
                System.out.println("Nu se poate strege atate litere.");
            }

            System.out.print("Dupa ce sa facut stergera " + sb_line.toString());
        }
        else
        {
            Scanner sc2 = new Scanner(new File("citire3_in.txt"));
            line = sc2.nextLine();
            insert = sc2.nextLine();
            val = sc2.nextInt();
            pozitie = sc2.nextInt();
            cate = sc2.nextInt();


            StringBuffer sb_line = new StringBuffer(line);

            if(val >= 0 && val <= sb_line.length())
            {
                sb_line.insert(val, insert+" ");

            }
            else
            {
                System.out.println("Nu se poate insera pe acea pozitie.");
            }

            System.out.println("Dupa ce sa facut inserarea : "+ sb_line.toString());

            if(cate >= 0 && pozitie+cate <= sb_line.length())
            {
                sb_line.delete(pozitie, pozitie+cate);
            }
            else
            {
                System.out.println("Nu se poate strege atate litere.");
            }

            System.out.print("Dupa ce sa facut stergera " + sb_line.toString());

        }



    }
}
