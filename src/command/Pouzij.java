package command;

import predmety.Predmet;
import svet.Mistnost;

import java.util.Scanner;

/**
 * Třída pro zpracování příkazu použít předmět z inventáře.
 */
public class Pouzij extends Command {
    private final Scanner sc;

    public Pouzij() {
        sc = new Scanner(System.in);
    }

    /**
     * Provede použití podle vybraného předmětu z inventáře.
     *
     * @return zprávu o úspěchu nebo chybě použití předmětu.
     */
    @Override
    public String execute() { //vymyslet lepsi reseni
        if (!hrac.getInventar().isEmpty()) {
            System.out.println(hrac.vypisInventar());
            System.out.print("Ktery predmet z inventare chces pouzit -> ");
            String predmet = sc.next();
            if (hrac.maPredmet(predmet)) {
                Predmet p = hrac.getPredmet(predmet);
                if (moznostPouziti(p)) {
                    System.out.println(p.pouziti());
                    hrac.odebratPredmet(p);
                }
            } else {
                return "Tento předmět nelze použít.";
            }
        } else {
            return "Tvůj inventář je prázdný.";
        }
        return "";
    }

    private boolean moznostPouziti(Predmet p) {
        boolean muzesPouzit = false;
        switch (p.getNazev()) {
            case "telefon":
                if (!hrac.maPredmet("simkarta"))
                    System.out.println("Nemůžeš nikomu zavolat, potřebuješ SIM kartu.");
                break;
            case "simkarta":
                if (!hrac.maPredmet("telefon"))
                    System.out.println("K použití SIM karty potřebuješ mobil.");
                break;
            case "baterka":
                if (!hrac.getAktualniMistnost().getNazev().equals("sklep"))
                    System.out.println("Doporučuji použít ve sklepě, je tam příšerná tma.");
                break;
            case "klic":
                if (!hrac.getAktualniMistnost().getNazev().equals("loznice")) {
                    System.out.println("Doporučuji použít k otevření zamčené místnosti");
                } else {
                    muzesPouzit = true;
                    Mistnost tajnaMistnost = svet.getMapa().get("tajna");
                    if (tajnaMistnost.isZamceno()) {
                        tajnaMistnost.setZamceno(false);
                    }
                }
                break;
            case "denik": muzesPouzit = true;
        }
        return muzesPouzit;
    }
}   /* switch (predmet) {
                    case "simkarta":
                        if (!hrac.maPredmet("telefon")) {
                            return "K použití SIM karty potřebuješ mobil.";
                        } else {
                            System.out.println(p.pouziti());
                            hrac.odebratPredmet(p.getNazev());
                        }
                        break;
                    case "telefon":
                        if (!hrac.maPredmet("SIMkarta")) {
                            return "Nemůžeš nikomu zavolat, potřebuješ SIM kartu.";
                        } else {
                            System.out.println(p.pouziti());
                            System.exit(0);
                        }
                        break;
                    case "baterka":
                        if (!hrac.getAktualniMistnost().getNazev().equals("sklep")) {
                            return "Doporučuji použít ve sklepě, je tam příšerná tma.";
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
                            return "";
                        }
                        break;
                    default:
                        hrac.odebratPredmet(p.getNazev());
                        System.out.println(p.pouziti());
                }*/