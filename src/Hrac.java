import predmety.Predmet;

import java.util.ArrayList;

public class Hrac {
    private ArrayList<Predmet> inventar;

    public void pridatPredmet(Predmet p) {
        inventar.add(p);
    }
    public void odebratPredmet(Predmet p) {
        inventar.remove(p);
    }

    public ArrayList<Predmet> getPredmety() {
        return inventar;
    }
    public boolean obsahujePredmet(Predmet p) {
        return inventar.contains(p);
    }

}
