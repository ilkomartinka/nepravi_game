package svet;

import hra.Hrac;
import postavy.NepraviPrarodice;
import postavy.Postava;
import postavy.PraviPrarodice;
import postavy.Segra;
import predmety.*;

import java.io.*;
import java.util.*;

public class Svet {
    private HashMap<String, Mistnost> mapa; // <název místnosti, objekt, který obsahuje podrobnosti o místnosti>

    public Svet() {
        this.mapa = new HashMap<>();
        nacteniMapy();
        pridaniPredmetu();
        pridaniPostav();
        mapa.get("tajna").setLock(true, "klic");
        mapa.get("sklep").setLock(true, "heslo");
    }

    public void nacteniMapy() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mapa.txt"));) {
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
        } catch (IOException e) {
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
        mapa.get("sklep").pridaniPredmetu("telefon", new Telefon());
    }

    public void pridaniPostav() {
        mapa.get("sklep").pridatPostavu(new PraviPrarodice());
        mapa.get("obyvak").pridatPostavu(new NepraviPrarodice());
        mapa.get("detska").pridatPostavu(new Segra());
    }

    public HashMap<String, Mistnost> getMapa() {
        return mapa;
    }

    public Segra najdiSegru() {
        for (Mistnost mistnost : mapa.values()) {
            if (mistnost.getPostava() instanceof Segra) {
                return (Segra) mistnost.getPostava();
            }
        }
        return null;
    }

    public void presunSegru(Mistnost novaMistnost) {
        Segra segra = najdiSegru();
        if (segra != null) {
            segra.setPoloha(novaMistnost);
            novaMistnost.pridatPostavu(segra);
        }
    }
}
