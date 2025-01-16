package problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainAppT1
{
    public static void main(String[] args)
    {
        List<PerecheNumere> listaNumere =citire();
        for(PerecheNumere per : listaNumere)
        {
            System.out.println("Pentru a="+per.getA()+" si b="+per.getB());
            System.out.println("Cele doua numere faca parte din sirul lui Fibonaci : "+per.perecheFibonaci(per.getA(), per.getB()));
            System.out.println("Cel mai mic multiplu comun a lui a si b este : "+per.cmmc(per.getA(), per.getB()));
            System.out.println("Cele doua numere au suma cifrelelor egala : "+per.sumaEgala(per.getA(), per.getB()));
            System.out.println("Cele doua numere au acelasi numar de cifere pare : "+per.nrCifrePare(per.getA(), per.getB()));
        }
        scriere(listaNumere);
    }

    static List<PerecheNumere> citire()
    {
        try
        {
            File file=new File("src/main/resources/numere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> perecheNumere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return perecheNumere;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static void scriere(List<PerecheNumere> lista)
    {
        try
        {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/numere.json");

            mapper.writeValue(file,lista);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
