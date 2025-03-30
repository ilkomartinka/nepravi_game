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
    public String execute() {
        try {
            if (!hrac.getInventar().isEmpty()) {
                System.out.println(hrac.vypisInventar());
                System.out.print("Ktery předmět z inventaře chceš použit (zpet) -> ");
                String odpoved = sc.nextLine().trim();
                if (odpoved.equals("zpet")) {
                    return "Nepoužil jsi žadný předmět";
                }
                if (hrac.maPredmet(odpoved)) {
                    Predmet p = hrac.getPredmet(odpoved);
                    if (moznostPouziti(p)) {
                        if(!p.getNazev().equals("simkarta")){
                            hrac.odebratPredmet(p);
                        }
                        System.out.println(p.pouziti());
                    }
                } else {
                    throw new IllegalArgumentException("Tento předmět neexistuje v tvém inventáři.");
                }
            } else {
                return "Tvůj inventář je prázdný.";
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
        return "Pokračuj dál";
    }

    /**
     * Zkontroluje, zda je možné použít daný předmět v aktuální situaci.
     *
     * @param p Předmět, který se pokoušíme použít.
     * @return true, pokud je předmět možné použít; jinak vyhodí výjimku.
     * @throws IllegalStateException Pokud není možné použít předmět v dané situaci.
     */
    private boolean moznostPouziti(Predmet p) {
        switch (p.getNazev()) {
            case "telefon":
                if (!hrac.maPredmet("simkarta")){
                    throw new IllegalStateException("Nemůžeš nikomu zavolat, potřebuješ SIM kartu.");
                }else{
                    konec();
                }
                break;
            case "simkarta":
                if (!hrac.maPredmet("telefon"))
                    throw new IllegalStateException("K použití SIM karty potřebuješ mobil.");
                break;
            case "baterka":
                if (!hrac.getAktualniMistnost().getNazev().equals("sklep")) {
                    throw new IllegalStateException("Doporučuji použít ve sklepě, je tam příšerná tma.");
                }
                break;
            case "klic":
                if (!hrac.getAktualniMistnost().getNazev().equals("loznice")) {
                    throw new IllegalStateException("Doporučuji použít k otevření zamčené místnosti");
                } else {
                    Mistnost tajnaMistnost = svet.getMapa().get("tajna");
                    if (tajnaMistnost.isZamceno()) {
                        tajnaMistnost.setZamceno(false);
                    }
                }
                break;
            case "denik":
                return true;
            default:
                throw new IllegalArgumentException("Tento předmět nelze použít.");
        }
        return true;
    }

    /**
     * Konec hry, kdy hráč vyhrál.
     * Zobrazí vítězný text.
     */
    private void konec(){
        System.out.println("""
                Hlas na druhé straně odpovídá:
                
                „Pomoc přijde co nejdříve, držte se!“
                
                Cítíš, jak z tebe padá veškeré napětí. Na chvíli se zastavíš a přemýšlíš, jak těžké to všechno bylo. Ale teď je to u konce.\
                
                Gratulujeme, právě jsi vyhrál(a)!""");
        System.exit(0);
    }
}