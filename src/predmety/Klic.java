package predmety;

import svet.Mistnost;

public class Klic extends Predmet {
    private Mistnost zamcenyPokoj;

    public Klic() {
        super("klic");
    }

    @Override
    public String pouziti() {
        //dopsat podminky
        return "Použil jsi klíč a otevřel sklep. Nyní můžeš vstoupit do sklepa.";
    }
}
