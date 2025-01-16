package exercitiul4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args)
    {
        Random random=new Random();

        int a1=random.nextInt(31);
        int b1=random.nextInt(31);

        System.out.println("a= "+a1);
        System.out.println("b= "+b1);

        int cmmdc=calculcmmdc(a1,b1);

        System.out.println("CMMDC: "+cmmdc);

    }


    public static int calculcmmdc(int a, int b)
    {
       if (a == 0) return b;
       if (b == 0) return a;

       while(b!=0)
        {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
