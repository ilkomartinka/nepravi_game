package command;

import predmety.Predmet;

public class Vezmi extends Command {

    public Vezmi() {
    }

    @Override
    public String execute() {
        if (hrac.getAktualniMistnost().obsahujePredmet()) {
            Predmet p = hrac.getAktualniMistnost().odebraniPredmetu();
            hrac.doplneniInventare(p);
            return "Vzal jsi: " + p.getNazev();
        }
        return "V této místnosti není žádný předmět.";
    }


}
