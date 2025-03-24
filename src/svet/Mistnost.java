package svet;

import postavy.Postava;
import predmety.Predmet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Třída reprezentující místnost ve hře.
 * Umožňuje manipulaci s předměty, sousedními místnostmi, zamčením místnosti a postavami.
 */
public class Mistnost {
    private String nazev;
    private HashMap<String, Predmet> predmety; //<nazev predmetu, predmet>
    private HashSet<String> sousedniMistnosti;
    private boolean zamceno;
    private String pomocnyPredmet; //k otevreni mistnosti
    private final ArrayList<Postava> postavy;
    private boolean prohledano;


    /**
     * Konstruktor pro vytvoření místnosti s daným názvem.
     * Inicializuje sousední místnosti, seznam předmětů a postav.
     *
     * @param name Název místnosti.
     */
    public Mistnost(String name) {
        this.nazev = name;
        this.sousedniMistnosti = new HashSet<>();
        this.predmety = new HashMap<>();
        this.zamceno = false;
        this.postavy = new ArrayList<>();
    }
    /**
     * Přidá nový předmět do místnosti.
     * Pokud již předmět s daným názvem existuje, vyvolá výjimku.
     * @param nazevPredmetu Název předmětu.
     * @param predmet Předmět, který má být přidán.
     * @throws IllegalArgumentException pokud předmět s daným názvem již existuje.
     */
    public void pridaniPredmetu(String nazevPredmetu, Predmet predmet) {
        if (predmety.containsKey(nazevPredmetu)) {
            throw new IllegalArgumentException("Předmět s tímto názvem již v místnosti existuje.");
        }else{
            predmety.put(nazevPredmetu, predmet);
        }
    }
    /**
     * Odebere předmět v místnosti, pokud nějaký existuje.
     * @return Odebraný předmět nebo null, pokud není žádný předmět.
     */
    public Predmet odebraniPredmetu() {
        if (!predmety.isEmpty()) {
            String key = predmety.keySet().iterator().next();
            return predmety.remove(key);
        }
        return null;
    }
    /**
     * Zjišťuje, zda místnost obsahuje nějaké předměty.
     * @return true, pokud místnost obsahuje předměty.
     */
    public boolean obsahujePredmet() {
        return !predmety.isEmpty();
    }

    /**
     * Vrací seznam všech předmětů v místnosti.
     * @return Seznam předmětů v místnosti.
     */
    public HashMap<String, Predmet> getPredmet() {
        return predmety;
    }
    /**
     * Nastavuje stav zamčení místnosti.
     * @param zamceno Indikuje, zda je místnost zamčená.
     * @param PomocnyPredmet Předmět, který je potřebný pro odemknutí místnosti.
     */
    public void setLock(boolean zamceno, String PomocnyPredmet) {
        this.zamceno = zamceno;
        this.pomocnyPredmet = PomocnyPredmet;
    }
    /**
     * Vrací pomocný předmět potřebný k odemknutí místnosti.
     * @return Název pomocného předmětu.
     */
    public String getPomocnyPredmet() {
        return pomocnyPredmet;
    }
    /**
     * Zjišťuje, zda je místnost zamčená.
     * @return true, pokud je místnost zamčená.
     */
    public boolean isZamceno() {
        return zamceno;
    }

    @Override
    public String toString() {
        return nazev;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mistnost mistnost = (Mistnost) o;
        return Objects.equals(nazev, mistnost.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nazev);
    }

    /**
     * Vrací název místnosti.
     * @return Název místnosti.
     */
    public String getNazev() {
        return nazev;
    }
    /**
     * Přidá sousední místnost k seznamu sousedních místností.
     * @param mistnost Název sousední místnosti.
     */
    public void pridaniMistnosti(String mistnost) {
        sousedniMistnosti.add(mistnost);
    }
    /**
     * Vrací seznam sousedních místností.
     * @return Seznam sousedních místností.
     */
    public HashSet<String> getSousedniMistnosti() {
        return sousedniMistnosti;
    }
    /**
     * Přidá postavu do místnosti.
     * @param postava Postava, která má být přidána do místnosti.
     */
    public void pridatPostavu(Postava postava) {
        postavy.add(postava);
    }
    /**
     * Vrací seznam postav v místnosti.
     * @return Seznam postav.
     */
    public ArrayList<Postava> getPostavy() {
        return postavy;
    }
    /**
     * Vrací postavu v místnosti, nebo null, pokud není žádná postava.
     * @return Postava v místnosti nebo null.
     */
    public Postava getPostava() {
        return postavy.isEmpty() ? null : postavy.get(0);
    }
    /**
     * Nastavuje, zda je místnost zamčená.
     * @param zamceno Stav zamčení místnosti.
     */
    public void setZamceno(boolean zamceno) {
        this.zamceno = zamceno;
    }
    /**
     * Zjišťuje, zda byla místnost prohledána.
     * @return true, pokud byla místnost prohledána, jinak false.
     */
    public boolean isProhledano() {
        return prohledano;
    }
    /**
     * Nastavuje stav prohledání místnosti.
     * @param prohledano Stav, který určuje, zda byla místnost prohledána (true) nebo ne (false).
     */
    public void setProhledano(boolean prohledano) {
        this.prohledano = prohledano;
    }

}
