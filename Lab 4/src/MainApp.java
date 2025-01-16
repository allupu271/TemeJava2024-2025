import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int opt;

        List<Echipament> listaEchipamente = new ArrayList<Echipament>();

        Scanner cin = new Scanner(System.in);
        Scanner cinf = new Scanner(new File("electronice.txt"));

        while (cinf.hasNext())
        {
            String[] line = cinf.nextLine().split(";");
            String nume = line[0];  // nume echipament
            int nr_inv = Integer.parseInt(line[1]); // numarul de bucati
            int pret = Integer.parseInt(line[2]); // pret per bucata
            String zona = line[3]; // zona in care este echipametul
            String stare = line[4]; //stare


            String tip = line[5];

            switch (tip) {
                case "imprimanta":
                    int pagini_ppm = Integer.parseInt(line[6]);
                    String rezolutie = line[7];
                    int p_car = Integer.parseInt(line[8]);
                    String tiparire = line[9];

                    if (Tiparire.color.toString().equalsIgnoreCase(tiparire))
                    {
                        Imprimante imprimante = new Imprimante(nume, nr_inv, pret, zona,stare, pagini_ppm, rezolutie, p_car, Tiparire.color);
                        listaEchipamente.add(imprimante);
                    }
                    else
                    {
                        Imprimante imprimante = new Imprimante(nume, nr_inv, pret, zona,stare, pagini_ppm, rezolutie, p_car, Tiparire.alb_negru);
                        listaEchipamente.add(imprimante);
                    }
                    break;
                case "copiator":
                    int p_ton = Integer.parseInt(line[6]);
                    String format= line[7];

                    if(Format.A3.toString().equalsIgnoreCase(format))
                    {
                        Copiatoare copiatoare =new Copiatoare(nume, nr_inv, pret, zona,stare,p_ton,Format.A3);
                        listaEchipamente.add(copiatoare);
                    }
                    else
                    {
                        Copiatoare copiatoare =new Copiatoare(nume, nr_inv, pret, zona,stare,p_ton,Format.A4);
                        listaEchipamente.add(copiatoare);
                    }
                    break;
                case "sistem de calcul":
                    String tip_mon= line[6];
                    String vit_proc= line[7];
                    int c_hdd= Integer.parseInt(line[8]);
                    String sistem= line[9];

                    if(Sistem.Linux.toString().equalsIgnoreCase(sistem))
                    {
                        Sisteme_de_calcul sisteme_de_calcul=new Sisteme_de_calcul(nume, nr_inv, pret, zona,stare,tip_mon,vit_proc,c_hdd,Sistem.Linux);
                        listaEchipamente.add(sisteme_de_calcul);
                    }
                    else
                    {
                        Sisteme_de_calcul sisteme_de_calcul=new Sisteme_de_calcul(nume, nr_inv, pret, zona,stare,tip_mon,vit_proc,c_hdd,Sistem.Windows);
                        listaEchipamente.add(sisteme_de_calcul);
                    }

                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        }

        while(true)
        {
            System.out.println("0.Exit");
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii în care se afla un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare ");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9.Afisarea echipamentelor vandute ");
            System.out.println("10.Salvarea in fisier binar.");
            System.out.println("11.Citirea din fisier binar.");
            System.out.print("Introduteti optiunea : ");
            opt=cin.nextInt();
            cin.nextLine(); // '\n'
            switch(opt)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Afisare_Echipamente(listaEchipamente);
                    System.out.print("\n");
                    break;
                case 2:
                    Afisare_Imprimata(listaEchipamente);
                    System.out.print("\n");
                    break;
                case 3:
                    Afisare_Copiator(listaEchipamente);
                    System.out.print("\n");
                    break;
                case 4:
                    Afisare_Sistem(listaEchipamente);
                    System.out.print("\n");
                    break;
                case 5:
                    System.out.print("Introduteti numele echipametului : ");
                    String nume=cin.nextLine();
                    System.out.print("Introduteti noul stare : ");
                    String stare=cin.nextLine();
                    Modificare_Stare(listaEchipamente,nume,stare);
                    System.out.print("\n");
                    break;
                case 6:
                    System.out.print("Introduteti numele al imprimati : ");
                    String nume1=cin.nextLine();
                    System.out.print("Introduteti noul mod de scriere in dpi : ");
                    String mod=cin.nextLine();
                    Modificare_Mod(listaEchipamente,nume1,mod);
                    System.out.print("\n");
                    break;
                case 7:
                    System.out.print("Introduteti numele copiatorului : ");
                    String nume2=cin.nextLine();
                    //System.out.print("Introduteti noul format : ");
                    //String form=cin.nextLine();
                    Modificare_format(listaEchipamente,nume2);
                    System.out.print("\n");
                    break;
                case 8:
                    System.out.print("Introduteti numele sistem de calcul : ");
                    String nume3=cin.nextLine();
                    System.out.print("Introduteti sistemul pe care doriti s-al instalati : ");
                    String sistem=cin.nextLine();
                    Instalare_Sistem(listaEchipamente,nume3,sistem);
                    System.out.print("\n");
                    break;
                case 9:
                    Afisare_Echipament_Vandute(listaEchipamente);
                    System.out.print("\n");
                    break;
                case 10:
                    scrie_bin(listaEchipamente,"echipamente.bin");
                    System.out.print("\n");
                    break;
                case 11:
                    List<Echipament> q;
                    q=(List<Echipament>) citeste_bin("echipamente.bin");
                    for(Echipament e:q)
                        System.out.println(e);
                    System.out.print("\n");
                    break;
                default: System.out.println("Ati introdus o optiune indinsponibila");

            }

        }

    }
    static void Afisare_Echipamente(List<Echipament> listaEchipamente)
    {
        for(Echipament e : listaEchipamente)
        {
            System.out.println(e);
        }
    }
    static void Afisare_Imprimata(List<Echipament> listaEchipamente)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e instanceof Imprimante )
            {
                System.out.println(e);
            }
        }
    }
    static void Afisare_Copiator(List<Echipament> listaEchipamente)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e instanceof Copiatoare )
            {
                System.out.println(e);
            }
        }
    }
    static void Afisare_Sistem(List<Echipament> listaEchipamente)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e instanceof Sisteme_de_calcul )
            {
                System.out.println(e);
            }
        }
    }
    static void Modificare_Stare(List<Echipament> listaEchipamente,String nume,String stare)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e.getNume().equalsIgnoreCase(nume))
            {
                e.setStare(stare);
                break;
            }
        }
    }
    static  void Modificare_Mod(List<Echipament> listaEchipamente,String nume,String mod)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e instanceof Imprimante )
            {
                if(e.getNume().equalsIgnoreCase(nume))
                {
                    ((Imprimante) e).setRezolutie(mod);
                    break;
                }
            }
        }
    }
    static void Modificare_format(List<Echipament> listaEchipamente,String nume)
    {
        for(Echipament e : listaEchipamente)
        {
            if(e instanceof Copiatoare)
            {
                if(e.getNume().equalsIgnoreCase(nume))
                {
                    if(((Copiatoare) e).getFormat()==Format.A3)
                    {
                        ((Copiatoare) e).setFormat(Format.A4);
                    }
                    else
                    {
                        ((Copiatoare) e).setFormat(Format.A3);
                    }
                    break;
                }
            }
        }
    }
    static void Instalare_Sistem(List<Echipament> listaEchipamente,String nume,String sistema)
    {
        for(Echipament e:listaEchipamente)
        {
            if(e instanceof Sisteme_de_calcul)
            {
                if(e.getNume().equalsIgnoreCase(nume))
                {
                    if(Sistem.Windows.toString().equalsIgnoreCase(sistema))
                    {
                        ((Sisteme_de_calcul) e).setSistem(Sistem.Windows);
                        break;
                    }
                    if(Sistem.Linux.toString().equalsIgnoreCase(sistema))
                    {
                        ((Sisteme_de_calcul) e).setSistem(Sistem.Linux);
                        break;
                    }
                }
            }
        }
    }
    static void Afisare_Echipament_Vandute(List<Echipament> listaEchipament)
    {
        for(Echipament e : listaEchipament)
        {
            if(e.getStare().equalsIgnoreCase("vandut"))
            {
                System.out.println(e);
            }
        }
    }

    static void scrie_bin(Object o,String fis)
    {
        try
        {
            FileOutputStream f=new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    static Object citeste_bin(String fis)
    {
        try {
            FileInputStream f=new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}