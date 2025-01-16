package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n= ");
        int n = scanner.nextInt();
        System.out.println("numarul ai carui divizori ii cautam este: "+n);
        scanner.close();
        int Prim=0;


        for(int i=2;i<n/2;i++)
        {
            if(n%i==0)
            {
                System.out.println(i);
                Prim++;
            }
        }

        if(Prim==0)
            System.out.println("numarul este prim");


    }
}