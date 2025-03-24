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
        Segra segra = svet.najdiSegru();
        System.out.println("Prohledavani mistnosti..." + mistnost.getNazev());
        if (mistnost.obsahujePredmet()) {
            Predmet predmet = mistnost.getPredmet().values().iterator().next();
            hrac.getAktualniMistnost().setProhledano(true);
            return "Nalezen novy predmet -> " + predmet.toString();
        }
        return switch ((mistnost.getNazev())) {
            case "obyvak" -> {
                mistnost.getPostava().setStav("podezreni");
                yield mistnost.getPostava().komunikace(mistnost.getPostava().getStav());
            }
            case "tajna" -> segra.komunikace("odhaleni");
            case "knihovna" -> segra.komunikace("heslo");
            case "sklep" -> mistnost.getPostava().komunikace("vysvetleni");
            default -> "Zadny predmet nebyl nelezen";
        };
    }

}

