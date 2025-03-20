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
        }
        switch ((mistnost.getNazev())){
            case "obyvak":
                mistnost.getPostava().setStav("podezreni");
                return mistnost.getPostava().komunikace(mistnost.getPostava().getStav());
            case "tajna":
                return segra.komunikace("odhaleni");
            case "knihovna":
                return segra.komunikace("heslo");
            case "sklep":
                return mistnost.getPostava().komunikace("vysvetleni");
            default:
                return "Zadny predmet nebyl nelezen";
        }
    }

}

