package predmety;

import hra.Hrac;

public abstract class Predmet {
    protected String nazev;

    public abstract String pouziti();

    public Predmet(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }
}
