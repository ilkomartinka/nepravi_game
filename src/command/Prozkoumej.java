package command;

import postavy.Segra;
import predmety.Predmet;
import svet.Mistnost;

/**
 * Třída {@code Prozkoumej} představuje příkaz, který umožňuje hráči prozkoumat aktuální místnost.
 */
public class Prozkoumej extends Command {
    public Prozkoumej() {
    }

    /**
     * Provádí prozkoumání aktuální místnosti.
     * Pokud je v místnosti předmět, hráč ho nalezne.
     * V závislosti na názvu místnosti může být také vyvolána speciální komunikace s postavami.
     *
     * @return Zpráva o výsledku prohledání místnosti nebo interakci s postavami.
     */
    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        Segra segra = svet.najdiSegru();
        // Pokud se hráč nachází ve sklepě a nemá baterku, zobrazí se varování a prohledání nebude možné.
        if (mistnost.getNazev().equals("sklep") && !hrac.maPredmet("baterka"))
            return "Ve sklepě je tma, nejdřív musíš rozsvítit!";
        // Pokud se hráč nachází ve sklepě a má baterku, baterka se použije.
        else if(mistnost.getNazev().equals("sklep") && hrac.maPredmet("baterka")){
            System.out.println(hrac.getPredmet("baterka").pouziti());
        }

        System.out.println("Prohledavani mistnosti..." + mistnost.getNazev());
        if (mistnost.obsahujePredmet()) {
            Predmet predmet = mistnost.getPredmet().values().iterator().next();
            hrac.getAktualniMistnost().setProhledano(true);
            return "Nalezen novy predmet -> " + predmet.toString();
        }
        // Interakce s postavami podle aktuální místnosti
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