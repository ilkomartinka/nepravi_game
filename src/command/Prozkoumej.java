package command;

import svet.Mistnost;

public class Prozkoumej extends Command {
    public Prozkoumej() {
    }

    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        System.out.println("Prohledavani mistnosti..." + mistnost);
        if (mistnost.obsahujePredmet()) {
            return "Najden novy predmet -> " + mistnost.getPredmet().getNazev();
        }
        return "Zadny predmet nebyl najden";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
