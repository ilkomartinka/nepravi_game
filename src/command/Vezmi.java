package command;

import predmety.Predmet;
/**
 * Třída {@code Vezmi} představuje příkaz pro vzetí předmětu z aktuální místnosti a přidání ho do inventáře hráče.
 * Tento příkaz kontroluje, zda je v místnosti předmět, a zda byla místnost prohledána.
 */
public class Vezmi extends Command {
    /**
     * Konstruktor třídy
     */
    public Vezmi() {
    }

    /**
     * Provádí vzetí předmětu v aktuální místnosti. Pokud je místnost prohledána a obsahuje předmět, předmět je
     * odebrán z místnosti a přidán do inventáře hráče. Pokud místnost není prohledaná nebo neobsahuje žádný předmět,
     * hráč dostane odpovídající zprávu.
     *
     * @return zpráva o úspěšném sebrání předmětu nebo o chybě.
     */
    @Override
    public String execute() {
        if (hrac.getAktualniMistnost().obsahujePredmet()) {
            if (hrac.getAktualniMistnost().isProhledano()) {
                Predmet p = hrac.getAktualniMistnost().odebraniPredmetu();
                hrac.doplneniInventare(p);
                return "Vzal jsi: " + p.getNazev();
            }
        } else {
            return "V této místnosti není žádný předmět.";
        }
        return "Nejdriv musis mistnost prohledat";
    }
}
