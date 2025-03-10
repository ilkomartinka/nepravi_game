package predmety;

import svet.Mistnost;

public class Klic extends Predmet {
    private Mistnost zamcenyPokoj;

    public Klic() {
        super("klic");
    }

    @Override
    protected String pouziti() {
        return "";
    }
}
