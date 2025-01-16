package Problema_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp2
{

    public static void main(String[] args) throws FileNotFoundException
    {

        List<Produs> listaProduse= new ArrayList<Produs>();
        int opt;
        float pretMinim=1000;
        String[] line;

        Scanner cinf =new Scanner(new File("produse.csv"));

        while(cinf.hasNext())
        {
            line=cinf.nextLine().split(",");
            String nume=line[0];
            float pret=Float.parseFloat(line[1]);
            int catitate=Integer.parseInt(line[2]);
            LocalDate date=LocalDate.parse(line[3]);

            if(pret<=pretMinim)
            {
                pretMinim=pret;
            }

            Produs produs=new Produs(nume,pret,catitate,date);

            listaProduse.add(produs);
        }

        cinf.close();

        do{
            System.out.println("1. Afisare produse.");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Cuparare unui produs");
            System.out.println("4. Pordusele care au pret minim");
            System.out.println("5. Slvarea produse cu o anumita catitate");
            System.out.println("6. Iesire.");

            Scanner cin = new Scanner(System.in);
            System.out.print("Introduteti optiunea : ");
            opt = cin.nextInt();

            switch(opt)
            {
                case 1:
                    Afisare(listaProduse);
                    break;
                case 2:
                    AfisareProdusExpirat(listaProduse);
                    break;
                case 3:
                    System.out.print("Introduceti numele produsului : ");
                    String nume=cin.next();
                    System.out.print("Introduceti numarul de bucati : ");
                    int catitate=cin.nextInt();
                    VideProdus(listaProduse,nume,catitate);
                    break;
                case 4:
                    PertMinim(listaProduse,pretMinim);
                    break;
                case 5:
                    System.out.print("Introduceti numarul de bucati : ");
                    int catitate1=cin.nextInt();
                    Salvare(listaProduse,catitate1);
                    break;
                case 6:
                    cin.close();
                    System.exit(0);
                    break;
                case 7:
                        System.out.print("Suma incasata este : "+ Produs.incasari);
                        System.out.println("\n");
                    break;
                default:
            }

        }while(true);


    }

    public static void Afisare(List<Produs> listaProduse)
    {
        for(Produs produs: listaProduse)
        {
            System.out.println(produs);
        }
        System.out.print("\n");
    }

    public static void AfisareProdusExpirat(List<Produs> listaProduse)
    {
        LocalDate today = LocalDate.now();
        for (Produs produs: listaProduse)
        {
            if (produs.getDataExpirare().isBefore(today))
            {
                System.out.println(produs);
            }
        }
        System.out.print("\n");
    }

    public static void VideProdus(List<Produs> listaProduse,String nume,int catitate)
    {
        for(Produs produs: listaProduse)
        {
            if(produs.getNume().equalsIgnoreCase(nume))
            {
                if(catitate<=produs.getBucat())
                {
                    float val1= produs.pert()* Float.valueOf(catitate);

                    if(produs.getBucat()-catitate==0)
                    {
                        listaProduse.remove(produs);
                        //produs.setIncasari(val1);
                        Produs.incasari=val1;
                        break;
                    }
                    else
                    {
                        produs.setBucati(catitate);
                        produs.setIncasari(val1);
                    }

                }
                else
                {
                    System.out.println("Nu aveme suficiete bucati pe stoc.");
                }
            }
        }
        System.out.print("\n");
    }

    public static void PertMinim(List<Produs> listaProduse,float minim)
    {
        for(Produs produs: listaProduse)
        {
            if(produs.pert()==minim)
            {
                System.out.println(produs);
            }
        }
        System.out.print("\n");
    }

    public static void Salvare(List<Produs> listaProduse,int catitate) throws FileNotFoundException
    {

        PrintStream cinfs = new PrintStream("salvare_out.txt");

        for(Produs produs: listaProduse)
        {
            if(produs.getBucat()<catitate)
            {
                cinfs.println(produs);
            }
        }
        cinfs.close();
    }
}
