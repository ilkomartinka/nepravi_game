package command;

import predmety.Predmet;

public class Vezmi extends Command {

    public Vezmi() {
    }

    @Override
    public String execute() {
        if (hrac.getAktualniMistnost().obsahujePredmet() && hrac.getAktualniMistnost().isProhledano()) {
            Predmet p = hrac.getAktualniMistnost().odebraniPredmetu();
            hrac.doplneniInventare(p);
            return "Vzal jsi: " + p.getNazev();
        }else{
            return "Mistnost nejdtiv musis prohledat nebo v této místnosti není žádný předmět.";
        }
    }


}
