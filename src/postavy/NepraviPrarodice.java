package postavy;

import java.util.ArrayList;
import java.util.Random;
/**
 * Třída představující falešné prarodiče hráče.
 */
public class NepraviPrarodice extends Postava {
    private final ArrayList<String> dostupneRepliky = new ArrayList<>();
    private String posledniReplika = " ";
    /**
     * Konstruktor pro vytvoření falešných prarodičů.
     */
    public NepraviPrarodice() {
        super("Prarodiče", "Prarodiče tráví nejvíc času v obyvaku.");
        pridatKomunikaci("uvod", "Prarodiče: No konečně... Ach, jak dlouho jsme na vás čekali! Jen pojďte dál, děti..." +
                "\nToto je váš pokoj. Rozložte si věci.");
        pridatKomunikaci("podezreni", "Děda: Co tam děláš? Nic zajímavého tam nenajdeš." +
                "\nBabička: Neměl by ses hrabat v cizích věcech, drahoušku...");
        dostupneRepliky.add("Prarodiče: Jsme tak rádi, že jste tu! Už nikdy nemusíte odcházet.");
        dostupneRepliky.add("Děda: Dáte si čaj? Nebo raději něco silnějšího?");
        dostupneRepliky.add("Babička: Dnes bude k večeři něco speciálního. Doufám, že máte rádi překvapení...");
        dostupneRepliky.add("Prarodiče: Spali jste dobře? Doufáme, že ano... Opravdu doufáme.");
        dostupneRepliky.add("Děda: večer vám ukážu svůj speciální trik... No, pokud se dožijete večera.");
    }
    /**
     * Vrací náhodnou repliku falešných prarodičů.
     * @return Náhodná replika.
     */
    public String ziskatNahodnouRepliku() {
        Random random = new Random();
        String novaReplika;
        do {
            novaReplika = dostupneRepliky.get(random.nextInt(dostupneRepliky.size()));
        } while (novaReplika.equals(posledniReplika));
        posledniReplika = novaReplika;
        return novaReplika;
    }
}
