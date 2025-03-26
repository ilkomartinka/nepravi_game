package predmety;
/**
 * Předmět reprezentující klíč.
 */
public class Klic extends Predmet {

    public Klic() {
        super("klic");
    }

    @Override
    public String pouziti() {
        return "Použil jsi klíč a otevřel jsi tajnou mistnost.";
    }
}
