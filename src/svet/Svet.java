package svet;

import postavy.NepraviPrarodice;
import postavy.Postava;
import postavy.PraviPrarodice;
import postavy.Segra;
import predmety.*;

import java.io.*;
import java.util.*;

/**
 * Třída reprezentující svět, který obsahuje mapu místností, postavy a předměty.
 * Umožňuje načítání mapy, přidávání postav a předmětů do místností a interakci mezi postavami.
 */
public class Svet {
    private final HashMap<String, Mistnost> mapa; // <název místnosti, objekt který obsahuje podrobnosti o místnosti>

    /**
     * Konstruktor třídy Svet. Inicializuje mapu a volá metody pro načítání mapy, přidání předmětů a postav.
     */
    public Svet() {
        this.mapa = new HashMap<>();
        nacteniMapy();
        pridaniPredmetu();
        pridaniPostav();
        mapa.get("tajna").setLock(true, "klic");
        mapa.get("sklep").setLock(true, "heslo");
    }

    /**
     * Načte mapu místností ze souboru "mapa.txt" a propojí sousední místnosti.
     * Každý řádek souboru reprezentuje místnost a její sousedy.
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public void nacteniMapy() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mapa.txt"))) {
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

    /**
     * Vypiše seznam všech místností a jejich sousedních místností ve formátu:
     * "místnost -> [sousední místnosti]".
     *
     * @return String obsahující seznam místností a jejich propojení.
     */
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

    /**
     * Přidá předměty do specifických místností.
     */
    public void pridaniPredmetu() throws NullPointerException{
        mapa.get("kuchyn").pridaniPredmetu("klic", new Klic());
        mapa.get("detska").pridaniPredmetu("baterka", new Baterka());
        mapa.get("loznice").pridaniPredmetu("denik", new Denik());
        mapa.get("koupelna").pridaniPredmetu("SIMkarta", new SIMkarta());
        mapa.get("sklep").pridaniPredmetu("telefon", new Telefon());
    }

    /**
     * Přidá postavy do specifických místností.
     */
    public void pridaniPostav() throws NullPointerException{
            mapa.get("sklep").pridatPostavu(new PraviPrarodice());
            mapa.get("obyvak").pridatPostavu(new NepraviPrarodice());
            mapa.get("detska").pridatPostavu(new Segra());
    }

    /**
     * Vrátí mapu místností, která obsahuje všechny místnosti v tomto světě.
     *
     * @return Mapa obsahující všechny místnosti světa.
     */
    public HashMap<String, Mistnost> getMapa() {
        return mapa;
    }

    /**
     * Najde postavu "Segra" v mapě místností.
     *
     * @return Objekt typu Segra, pokud je nalezen, jinak null.
     */
    public Segra najdiSegru() {
        for (Mistnost mistnost : mapa.values()) {
            if (mistnost.getPostava() instanceof Segra) {
                return (Segra) mistnost.getPostava();
            }
        }
        return null;
    }

    /**
     * Přesune postavu "Segra" do nové místnosti.
     * Pokud postava existuje, je přesunuta do zadané místnosti a místnost je aktualizována.
     *
     * @param novaMistnost Nová místnost, do které bude postava "Segra" přesunuta.
     * @throws NullPointerException pokud postava Segra neexistuje.
     */
    public void presunSegru(Mistnost novaMistnost) {
        Segra segra = najdiSegru();
        if (segra != null) {
            segra.setPoloha(novaMistnost);
            novaMistnost.pridatPostavu(segra);
        }else{
            throw new NullPointerException("Postava Segra nebyla nalezena.");
        }
    }

    /**
     * Najde postavu "PraviPrarodice" v mapě místností.
     *
     * @return Objekt typu PraviPrarodice, pokud je nalezen, jinak null.
     */
    public PraviPrarodice najdiPravePrarodice() {
        for (Mistnost mistnost : mapa.values()) {
            for (Postava postava : mistnost.getPostavy()) {
                if (postava instanceof PraviPrarodice) {
                    return (PraviPrarodice) postava;
                }
            }
        }
        return null;
    }
}