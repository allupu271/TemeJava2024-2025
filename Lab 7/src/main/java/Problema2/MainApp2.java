package Problema2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainApp2 {
    public static void main(String[] args) {
        Set<InstrumentMuzical> lista = new LinkedHashSet<InstrumentMuzical>();
        //lista=citire();

        Chitara chitara = new Chitara("Fender", 1200, TipChitara.ACUSTICA, 6);
        lista.add(chitara);

        SetTobe tobe = new SetTobe("Pearl", 2500, TipTobe.ELECTRONICE, 7, 4);
        lista.add(tobe);

        lista.stream()
                .forEach(InstrumentMuzical::Afisare);


        scriere(lista);

    }

    public static void scriere(Set<InstrumentMuzical> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire() {
        try {
            File file = new File("src/main/resources/instrumente.json");
            ObjectMapper mapper = new ObjectMapper();
            Set<InstrumentMuzical> persoane = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>() {});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
