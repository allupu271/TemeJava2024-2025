package exercitiul5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {

        Random random=new Random();

        int numar=random.nextInt(21);

        System.out.println("Numarul intreg este: "+numar);

        if (IsFibonacci(numar))
        {
            System.out.println("Numărul " + numar + " aparține șirului lui Fibonacci.");
        }
        else
        {
            System.out.println("Numărul " + numar + " NU aparține șirului lui Fibonacci.");
        }
    }

    public static boolean IsFibonacci(int numar)
    {

        if (numar == 0 || numar == 1) {
            return true;
        }

        int a = 0, b = 1;
        while (b < numar) {
            int temp = a + b;
            a = b;
            b = temp;
        }


        return b == numar;
    }
}
