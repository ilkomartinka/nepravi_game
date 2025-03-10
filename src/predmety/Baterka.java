package predmety;

public class Baterka extends Predmet {
    private boolean sviti;

    public Baterka() {
        super("baterka");
        this.sviti = false;
    }

    @Override
    protected String pouziti() {
        return sviti ? "Zapnul jsi baterku." : "Vypnul jsi baterku.";
    }
}
