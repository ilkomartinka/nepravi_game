package command;

import postavy.NepraviPrarodice;
import postavy.Postava;
import postavy.PraviPrarodice;
import postavy.Segra;
import svet.Mistnost;

/**
 * Třída {@code Mluv} umožňuje komunikaci s postavami v místnosti.
 * Pokud je v aktuální místnosti postava, hráč může s ní komunikovat a získat její repliku.
 */
public class Mluv extends Command {
    /**
     * Provádí komunikaci s postavou v aktuální místnosti.
     * V závislosti na typu postavy vrátí odpověď.
     * Pokud postava v místnosti není, nebo není možné komunikovat, vrátí zprávu o chybě.
     *
     * @return Odpověď postavy, nebo zprávu o chybě.
     */
    @Override
    public String execute() {
        try {
            Mistnost mistnost = hrac.getAktualniMistnost();
            if (mistnost != null) {
                Postava postava = mistnost.getPostava();
                if (postava instanceof NepraviPrarodice) {
                    return ((NepraviPrarodice) postava).ziskatNahodnouRepliku();
                } else if (postava instanceof Segra segra) {
                    String odpoved = segra.komunikace(segra.getStav());
                    segra.nastavNovyStav();
                    return odpoved;
                } else if (hrac.getAktualniMistnost().getNazev().equals("sklep")) {
                    PraviPrarodice praviPrarodice = (PraviPrarodice) postava;
                    System.out.println(praviPrarodice.komunikace("uvod"));
                }else if(postava == null){
                    throw new IllegalStateException("V této místnosti není žádná postava.");
                }
            }throw new IllegalStateException("Aktuální místnost není nastavena.");
        } catch (ClassCastException e) {
            return "Chyba: Nesprávný typ postavy v místnosti.";
        } catch (Exception e) {
            return "Nastala neočekávaná chyba při komunikaci s postavou: " + e.getMessage();
        }
    }
}
