package command;

import predmety.Baterka;
import predmety.Klic;
import predmety.Predmet;

import java.util.Scanner;

public class Pouzij extends Command {
    private Scanner sc = new Scanner(System.in);

    public Pouzij() {

    }

    @Override
    public String execute() {
        System.out.println("Ktery predmet z inventare chces pouzit ->");
        hrac.getInventar();
        String predmet = sc.next();
        if (hrac.maPredmet(predmet)) {
            Predmet p = hrac.odebratPredmet(predmet);
            System.out.println(p.pouziti());
        } else {
            return "Tento predmet nelze pouzit";
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
