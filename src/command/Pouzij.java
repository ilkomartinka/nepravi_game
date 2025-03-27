package command;

import predmety.Predmet;
import svet.Mistnost;

import java.util.Scanner;

/**
 * Třída pro zpracování příkazu použít předmět z inventáře.
 */
public class Pouzij extends Command {
    private final Scanner sc = new Scanner(System.in);

    public Pouzij() {

    }

    /**
     * Provede použití podle vybraného předmětu z inventáře.
     *
     * @return zprávu o úspěchu nebo chybě použití předmětu.
     */
    @Override
    public String execute() { //vymyslet lepsi reseni
        if (!hrac.getInventar().isEmpty()) {
            System.out.print(hrac.getInventar());
            System.out.print("\nKtery predmet z inventare chces pouzit -> ");
            String predmet = sc.next();
            if (hrac.maPredmet(predmet)) {
                Predmet p = hrac.getPredmet(predmet);
                switch (predmet) {
                    case "SIMkarta":
                        if (!hrac.maPredmet("telefon")) {
                            return "k pouziti simkarty potrebujes mobil";
                        } else {
                            System.out.println(p.pouziti());
                            hrac.odebratPredmet(p.getNazev());
                        }
                        break;
                    case "telefon":
                        if (!hrac.maPredmet("SIMkarta")) {
                            return "nemuzes nikomu zavolat, potrebujes SIMkartu";
                        } else {
                            System.out.println(p.pouziti());
                            System.exit(0);
                        }
                        break;
                    case "baterka":
                        if (!hrac.getAktualniMistnost().getNazev().equals("sklep")) {
                            return "doporucuju pouzit v sklepe, je tam priserna tma";
                        } else {
                            System.out.println(p.pouziti());
                        }
                        break;
                    case "klic":
                        if (hrac.getAktualniMistnost().getNazev().equals("loznice")) {
                            Mistnost tajnaMistnost = svet.getMapa().get("tajna");
                            if (tajnaMistnost.isZamceno()) {
                                tajnaMistnost.setZamceno(false);
                                System.out.println(p.pouziti());
                                hrac.odebratPredmet(p.getNazev());
                            }
                        } else {
                            return "doporucuju pouzit k otevreni zamcene mistnosti";
                        }
                        break;
                    default:
                        hrac.odebratPredmet(p.getNazev());
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