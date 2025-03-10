package svet;

import predmety.Baterka;
import predmety.Klic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Svet {
    public static HashMap<Mistnost, ArrayList<Mistnost>> svet = new HashMap<>();

    public Svet() {
        nacteniMapy();
        pridatPredmety();
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

    /*public HashMap<Mistnost, ArrayList<Mistnost>> getSvet() {
        return svet;
    }*/

    public ArrayList<Mistnost> moznostPohybu(Mistnost mistnost) {
        return svet.get(mistnost);
    }

    public void printMap() {
        for (Map.Entry<Mistnost, ArrayList<Mistnost>> entry : svet.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private void pridatPredmety() {
        for (Mistnost mistnost : svet.keySet()) {
            switch (mistnost.getNazev().toLowerCase()) {
                case "detska":
                    mistnost.nastavPredmet(new Baterka());
                    break;
                case "kuchyn":
                    mistnost.nastavPredmet(new Klic());
                    break;
            }
        }

    }
}