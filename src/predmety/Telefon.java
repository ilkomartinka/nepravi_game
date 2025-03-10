package predmety;

public class Telefon extends Predmet{
    private boolean finguje;

    public Telefon(String nazev) {
        super("telefon");
    }

    @Override
    protected String pouziti() {
        return "";
    }
}
