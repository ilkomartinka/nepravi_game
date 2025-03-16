package command;
import predmety.Predmet;
import svet.Mistnost;

public class Prozkoumej extends Command {
    public Prozkoumej() {
    }

    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        System.out.println("Prohledavani mistnosti..." + mistnost.getNazev());
        if(mistnost.obsahujePredmet()){
            Predmet predmet = mistnost.getPredmet().values().iterator().next();
            return "Nalezen novy predmet -> " + predmet.toString();
        }
        return "Zadny predmet nebyl nelezen";
    }
}
