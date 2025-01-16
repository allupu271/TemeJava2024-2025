package problema2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainAppT2
{
    public static void main(String[] args)
    {
        int lungime=2800,latime=2070;
        List<Mobilier> Mobilier = citire();
        afisare(Mobilier);
        nr_coli(Mobilier,lungime,latime);
        scriere(Mobilier);
    }

    static List<Mobilier> citire()
    {
        try
        {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Mobilier> mobiliers = mapper.readValue(file, new TypeReference<List<Mobilier>>(){});
            return mobiliers;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    static void afisare(List<Mobilier> mobila)
    {
        for(Mobilier mobilier : mobila)
        {
            System.out.println("Nume: "+ mobilier.getNume());
            for(Placa placa: mobilier.getPlaci())
            {
                System.out.println("  Descriere: " + placa.getDescriere());
                System.out.println("  Lungime: " + placa.getLungime());
                System.out.println("  Lățime: " + placa.getLatime());
                System.out.println("  Orientare: " + placa.getOrientare());
                System.out.println("  Canturi: " + Arrays.toString(placa.getCanturi()));
                System.out.println("  Nr bucăți: " + placa.getNr_bucati());
                System.out.println();
            }
        }
    }

    static void nr_coli(List<Mobilier> mobila,int lungime,int latime)
    {
        int suprafataCola=lungime*latime;
        int suprafataCopr,supraftaplaca,nr;

        for(Mobilier mobilier : mobila)
        {
            suprafataCopr=0;
            for(Placa placa : mobilier.getPlaci())
            {
                supraftaplaca=placa.getLungime()*placa.getLatime();
                suprafataCopr+=supraftaplaca*placa.getNr_bucati();
            }
            System.out.println("Suprafata coli de pal este "+suprafataCola + "mm");
            System.out.println("Suprafata totala a corpului "+mobilier.getNume() + " este de : "+suprafataCopr + "mm.");
            nr=(int) Math.ceil((double) suprafataCopr/suprafataCola);
            System.out.println("Pentru corpul "+ mobilier.getNume()+" sunt necesta "+ nr +" placi pal.");
        }
    }

    static void scriere(List<Mobilier> mobiliers)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file=new File("src/main/resources/mobilier.json");

            mapper.writeValue(file,mobiliers);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
