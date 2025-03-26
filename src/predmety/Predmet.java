package predmety;

import hra.Hrac;
/**
 * Abstraktní třída představující předmět, který může hráč použít.
 */
public abstract class Predmet {
    protected String nazev;
    /**
     * Metoda, která definuje použití předmětu.
     */
    public abstract String pouziti();

    /**
     * Konstruktor pro vytvoření předmětu.
     * @param nazev Název předmětu
     */
    public Predmet(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return getNazev();
    }
}
