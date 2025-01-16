package exercitiul1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);
        System.out.print("lungime=");
        int L=scanner.nextInt();
        System.out.println("lungimea dreptunghilui este: "+L);

        System.out.print("latime=");
        int l=scanner.nextInt();
        System.out.println("latimea dreptunghiului este: "+l);

        int P=2*L+2*l;
        System.out.println("perimtrul dreptunghilui este: "+P);

        int A=L*l;
        System.out.println("aria dreptunghiului este: "+A);

    }
}
