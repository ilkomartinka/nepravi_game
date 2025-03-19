package command;

import postavy.Segra;
import predmety.Predmet;
import svet.Mistnost;

public class Prozkoumej extends Command {
    public Prozkoumej() {
    }

    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        System.out.println("Prohledavani mistnosti..." + mistnost.getNazev());
        Segra segra = svet.najdiSegru();
        if (mistnost.obsahujePredmet()) {
            Predmet predmet = mistnost.getPredmet().values().iterator().next();
            return "Nalezen novy predmet -> " + predmet.toString();
        } else if (mistnost.getNazev().equals("obyvak")) {
            mistnost.getPostava().setStav("podezreni");
            return mistnost.getPostava().komunikace(mistnost.getPostava().getStav());
        } else if (mistnost.getNazev().equals("tajna")) {
            System.out.println(segra.komunikace("odhaleni"));
        }else if(mistnost.getNazev().equals("knihovna")){
            System.out.println(segra.komunikace("heslo"));
        }
        return "Zadny predmet nebyl nelezen";
    }

}

