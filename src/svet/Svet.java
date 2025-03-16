package svet;

import predmety.Baterka;
import predmety.Denik;
import predmety.Klic;
import predmety.SIMkarta;

import java.io.*;
import java.util.*;

public class Svet {
    private HashMap<String,Mistnost> mapa; // <název místnosti, objekt, který obsahuje podrobnosti o místnosti>

    public Svet() {
        this.mapa = new HashMap<>();
        nacteniMapy();
        pridaniPredmetu();
    }
    public void nacteniMapy(){
        try(BufferedReader reader = new BufferedReader(new FileReader("mapa.txt"));){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] mistnosti = line.split(" ");
                String mistnost = mistnosti[0];

                mapa.putIfAbsent(mistnost, new Mistnost(mistnost)); // Pokud místnost ještě neexistuje v mapě, přidáme ji

                for (int i = 1; i < mistnosti.length; i++) {
                    String mistnostVedle = mistnosti[i];
                    mapa.putIfAbsent(mistnostVedle, new Mistnost(mistnostVedle));
                    mapa.get(mistnost).pridaniMistnosti(mistnostVedle); // Přidání propojení mezi hlavní místností a sousední místností
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public String printMapa() {
        StringBuilder mapaString = new StringBuilder();
        if (!mapa.isEmpty()) {
            for (Mistnost mistnost : mapa.values()) {
                mapaString.append(mistnost.getNazev())
                        .append(" -> ")
                        .append(mistnost.getSousedniMistnosti())
                        .append("\n");
            }
        }
        return mapaString.toString();
    }

    public void pridaniPredmetu() {
        mapa.get("kuchyn").pridaniPredmetu("klic", new Klic());
        mapa.get("detska").pridaniPredmetu("baterka", new Baterka());
        mapa.get("loznice").pridaniPredmetu("denik", new Denik());
        mapa.get("koupelna").pridaniPredmetu("SIMkarta", new SIMkarta());
    }

    public HashMap<String, Mistnost> getMapa() {
        return mapa;
    }
}
