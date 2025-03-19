package command;

import predmety.Predmet;
import svet.Mistnost;

import java.util.Scanner;

public class Pouzij extends Command {
    private final Scanner sc = new Scanner(System.in);

    public Pouzij() {

    }

    @Override
    public String execute() {
        if (!hrac.getInventar().isEmpty()) {
            System.out.print(hrac.getInventar());
            System.out.print("\nKtery predmet z inventare chces pouzit -> ");
            String predmet = sc.next();
            if (hrac.maPredmet(predmet)) {
                switch (predmet) {
                    case "SIMkarta":
                        if (!hrac.maPredmet("mobil")) {
                            return "k pouziti simkarty potrebujes mobil";
                        }
                    case "mobil":
                        if (!hrac.maPredmet("SIMkarta")) {
                            return "nemuzes nikomu zavolat, chybi ti SIMkarta";
                        }
                    case "baterka":
                        if (!hrac.getAktualniMistnost().getNazev().equals("sklep")) {
                            return "doporucuju pouzit v sklepe, je tam priserna tma";
                        }
                    case "klic":
                        if (hrac.getAktualniMistnost().getNazev().equals("loznice")) {
                            Mistnost tajnaMistnost = svet.getMapa().get("tajna");
                            if (tajnaMistnost.isZamceno()) {
                                tajnaMistnost.setZamceno(false);
                            }
                        }else{
                            return "doporucuju pouzit k otevreni zamcene mistnosti";
                        }
                    default:
                        Predmet p = hrac.odebratPredmet(predmet);
                        System.out.println(p.pouziti());
                }
            } else {
                return "Tento predmet nelze pouzit";
            }
        } else {
            return "Tvůj inventář je prázdný.";
        }
        return "";
    }


}
