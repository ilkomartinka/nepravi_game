package predmety;

public abstract class Predmet {
    protected String nazev;

    protected abstract String pouziti();

    public Predmet(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }
}
