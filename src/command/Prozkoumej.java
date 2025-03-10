package command;

import hra.Hrac;
import svet.Mistnost;

public class Prozkoumej implements Command{
    private Hrac hrac;
    private Mistnost mistnost;
    public Prozkoumej(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute() {
        this.mistnost = hrac.getAktualniMistnost();
        System.out.println("Prohledavani mistnosti..." + mistnost);
        if(mistnost.obsahujePredmet()){
            mistnost.getPredmet().getNazev();
        }
        return "V pokoji neni zadny predmet";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
