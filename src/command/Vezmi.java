package command;

import hra.Hrac;
import predmety.Predmet;
import svet.Mistnost;

public class Vezmi implements Command{

    private Mistnost mistnost;
    private Hrac hrac;



    public Vezmi() {
    }



    @Override
    public String execute() {
        this.hrac = new Hrac();
        this.mistnost = hrac.getAktualniMistnost();
        if(mistnost.obsahujePredmet()) {
            Predmet p = mistnost.odebratPredmet();
            hrac.pridatPredmet(p);
            System.out.println("Vzal jsi: " + p.getNazev());
        }
        return "V této místnosti není žádný předmět.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
