package svet;

import predmety.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Svet {
    public HashMap<Mistnost, ArrayList<Mistnost>> svet = new HashMap();

    public Svet() {
        nacteniMapy();
        pridaniPredmetu();
    }

    private void nacteniMapy() {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] mistnosti = line.split(" ");
                Mistnost mistnost = new Mistnost(mistnosti[0]);
                ArrayList<Mistnost> mistnostiVedle = new ArrayList<>();
                for (int i = 1; i < mistnosti.length; i++) {
                    mistnostiVedle.add(new Mistnost(mistnosti[i]));
                }
                svet.put(mistnost, mistnostiVedle);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mistnost> moznostPohybu(Mistnost mistnost) {
        return svet.get(mistnost);
    }

    public void printMap() {
        for (Map.Entry<Mistnost, ArrayList<Mistnost>> entry : svet.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    public Mistnost getMistnost(String nazev) {
        for (Mistnost mistnost : svet.keySet()) {
            if (mistnost.getNazev().equals(nazev)) {
                return mistnost;
            }
        }
        return null;
    }

//PRIDAVA SE JENOM BATERKA, POMOC
    public void pridaniPredmetu() {
       getMistnost("kuchyn").nastavPredmet(new Klic());
        //System.out.println("Předmět byl přidán do kuchyně");

        getMistnost("detska").nastavPredmet(new Baterka());
        //System.out.println("Předmět byl přidán do dětského pokoje");

        getMistnost("loznice").nastavPredmet(new Denik());
        //System.out.println("Předmět byl přidán do ložnice");

        getMistnost("koupelna").nastavPredmet(new SIMkarta());
        //System.out.println("Předmět byl přidán do koupelny");

        }
    }