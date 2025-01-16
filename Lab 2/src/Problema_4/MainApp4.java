package Problema_4;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp4
{
    public static void main(String[] args)
    {
        int i,n,j,s=0,val1,val2,cifra_control;
        String nume = "",cnp="",validare="Bun",control="279146358279";
        String[] vector = new String[10];

        Scanner cin = new Scanner(System.in);
        System.out.print("Cate persone vreti sa introduteti : ");
        n = cin.nextInt();

        for(i=0;i<n;i++)
        {
            System.out.print("Introduceti numele : ");
            nume = cin.next();
            do
            {
                System.out.print("Introduceti CNP : ");
                cnp = cin.next();

                if (cnp.length()==13 )
                {
                    validare = "Bun";
                }
                else
                {
                    validare = "Eror";
                }

                for(j=0;j<13;j++)
                {
                    if(!Character.isDigit(cnp.charAt(j)))
                    {
                        validare= "Eror";
                        break;
                    }
                }

                if(cnp.charAt(0)!='1' && cnp.charAt(0)!='2' && cnp.charAt(0)!='5' && cnp.charAt(0)!='6')
                {
                    validare= "Eror";
                }

                for(j=0;j<12;j++)
                {
                    val1=Integer.parseInt(cnp.charAt(j)+"");
                    val2=Integer.parseInt(control.charAt(j)+"");
                    s=s+val1*val2;
                }

                if(s%11!=Integer.parseInt(cnp.charAt(12)+""))
                {
                    validare= "Eror";
                }

            }while(!validare.equals("Bun"));

            Persoana persoana =new Persoana(nume , cnp);
            vector[i] = nume + " " + cnp +" "+ persoana.getVarsa();
        }

        for(j=0;j<vector.length;j++)
        {
            System.out.println(vector[j]);
        }

    }
}
