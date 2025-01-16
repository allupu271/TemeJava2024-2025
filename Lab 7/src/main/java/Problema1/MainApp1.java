package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class MainApp1 {
    public static void main(String[] args) {
        Map<Integer, Carte> map = new HashMap<Integer, Carte>();
        map = citire();

        var map1 = map.entrySet();

        var it = map1.iterator();

        while (it.hasNext()) {
            var val = it.next();
            int key = val.getKey();
            Carte carte = val.getValue();

            System.out.println(key + " " + carte.titlul() + " " + carte.autorul() + " " + carte.anul());

        }


        System.out.println('\n' + "Cerinta 5" + '\n');


        Set<Carte> collect = map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(carte -> carte.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .collect(Collectors.toSet());

        System.out.println(collect);

        System.out.println('\n' + "Cerinta 6" + '\n');

        Set<Carte> autori = map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparing(carte -> carte.titlul()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(autori);


        map1.stream()
                .sorted(Map.Entry.comparingByValue((a,b)->a.titlul().compareToIgnoreCase(b.titlul())))
                        .forEach(System.out::println);


        System.out.println('\n' + "Cerinta 7" + '\n');

        map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .min(Comparator.comparing(carte -> carte.anul()))
                .ifPresentOrElse(System.out::println,()-> System.out.println("Nu avem carti inregistarate"));

    }


    public static void scriere(Map<Integer, Carte> map) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carte> map = mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>() {
                    });
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
