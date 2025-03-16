package predmety;

import svet.Mistnost;

public class Klic extends Predmet {

    public Klic() {
        super("klic");
    }

    @Override
    public String pouziti() {
        return "Použil jsi klíč a otevřel sklep. Nyní můžeš vstoupit do sklepa.";
    }
}
