package command;

import hra.Hrac;
import predmety.Predmet;


public class Vezmi extends Command{

    public Vezmi() {
    }



    @Override
    public String execute() {
        if(hrac.getAktualniMistnost().obsahujePredmet()) {
            Predmet p = hrac.getAktualniMistnost().odebratPredmet();
            hrac.doplneniInventare(p);
            System.out.println("Vzal jsi: " + p.getNazev());
            return String.valueOf(hrac.getInventar());
        }
        return "V této místnosti není žádný předmět.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
