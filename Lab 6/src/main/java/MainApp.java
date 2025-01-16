import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp
{

    public static void main(String[] args)
    {
        List<Angajat> listAngajat = citire();

        System.out.println("Cerinta 1");
        Afisare(listAngajat);

        System.out.println('\n'+"Cerinta 2");
        listAngajat.stream()
                .filter(angajat -> angajat.getSalariul()>2500)
                .map(angajat -> angajat.getNume()+ "  " + angajat.getSalariul())
                .forEach(System.out::println);

        System.out.println('\n'+"Cerinta 3");
        LocalDate today = LocalDate.now();

        var angajat_aprilie=listAngajat.stream()
                .filter(angajat -> angajat.getPostul().equalsIgnoreCase("sef")
                        || angajat.getPostul().equalsIgnoreCase("director")
                        && angajat.getData_angajare().getYear()==today.minusYears(1).getYear())
                .collect(Collectors.toList());
        Afisare(angajat_aprilie);

        System.out.println('\n'+"Cerinta 4");

        listAngajat.stream()
                .filter(angajat -> !angajat.getPostul().equalsIgnoreCase("sef")
                        && !angajat.getPostul().equalsIgnoreCase("director"))
                .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                .forEach(System.out::println);

        System.out.println('\n'+"Cerinta 5");

        listAngajat.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .toList()
                .forEach(System.out::println);

        System.out.println('\n'+"Cerinta 6");

        listAngajat.stream()
                .filter(angajat -> angajat.getSalariul()<3000)
                .map(angajat -> angajat.getSalariul())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println('\n'+"Cerinta 7");

        listAngajat.stream()
                .min(Comparator.comparing(Angajat::getData_angajare))
                .ifPresentOrElse(System.out::println,() -> System.out.println("Nu exista angajati"));

        System.out.println('\n'+"Cerinta 8");

        var salariu= listAngajat.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariul));

        System.out.println("Salariul maxim este : "+salariu.getMax());
        System.out.println("Salariul mediu este : "+String.format("%.1f", salariu.getAverage()));
        System.out.println("Salariul minim este : "+salariu.getMin());

        System.out.println('\n'+"Cerinta 9");

        listAngajat.stream()
                .map(Angajat::getNume)
                .filter(nume -> nume.equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(Ion -> System.out.print("Firma are cel puțin un Ion angajat"+'\n'),
                        ()-> System.out.print("Firma nu are nici un Ion angajat"+'\n'));

        System.out.println('\n'+"Cerinta 10");

        var nr=listAngajat.stream()
                .filter(angajat -> angajat.getData_angajare().getYear()==today.minusYears(1).getYear())
                .filter(angajat -> angajat.getData_angajare().getMonth().getValue()>=6
                        && angajat.getData_angajare().getMonth().getValue()<=8)
                .count();

        System.out.println("Numarul de persoane angajate in vara anului precedent este : "+ nr);


        scriere(listAngajat);
    }

    public static void Afisare(List<Angajat> listAngajat)
    {
        for(Angajat angajat : listAngajat)
        {
            System.out.println(angajat);
        }
    }

    //trebuie sa o iau din lab 5
    public static void scriere(List<Angajat> lista)
    {
        try
        {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    //trebuie sa o iau din lab 5 si sa mai pun o lini care este in lab 6
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> persoane = mapper
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) //lina din lab 6
                    .readValue(file, new TypeReference<List<Angajat>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //Asta este defintai fuctie pe care o foloseste exprexia Lambda
    public static void Afisare_filtrata(List<Angajat> listAngajat, Predicate<Angajat> predicate)
    {
        for(Angajat angajat : listAngajat)
        {
            if(predicate.test(angajat))
                System.out.println(angajat);
        }
    }

}


        /*Afisare_filtrata(listAngajat, new Predicate<Angajat>() {
            @Override
            public boolean test(Angajat p) {
                return p.getSalariul()>20;
            }
        });

        codul de sus este la fel ca cooul de jos

         //Afisare_filtrata(listAngajat, angajat -> angajat.getSalariul()>3000);//cu expresie Lambda
        */