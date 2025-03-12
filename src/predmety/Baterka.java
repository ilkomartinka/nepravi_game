package predmety;
public class Baterka extends Predmet {

    public Baterka() {
        super("baterka");
    }

    @Override
    public String pouziti() {
      return "Zapnul jsi baterku." ;
    }
}
