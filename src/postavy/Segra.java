package postavy;

import svet.Mistnost;
/**
 * Třída představující sestru hlavního hrdiny.
 */
public class Segra extends Postava {
    private Mistnost poloha;
    /**
     * Konstruktor pro vytvoření postavy sestry.
     */
    public Segra() {
        super("Megan", "Tvoje sestra. Chodí všude za tebou, jako tvůj stín... akorát s větší pusou.");
        pridatKomunikaci("uvod", "Megan: těším se, až se seznámíme. Pokud děda vypadá jako na fotkách, asi mu budu muset půjčit hřeben");
        pridatKomunikaci("podezreni", "Megan: Něco tady nehraje... Všimnul sis jak se chovaji?");
        pridatKomunikaci("krize", "Megan: Musíme odsud vypadnout, jinak jsme v háji!");
        pridatKomunikaci("sklep", "Megan: KOUKEJ TADY NEKDO JE");
        pridatKomunikaci("odhaleni", """
                Megan: Koukej našla jsem na stole staré noviny...\
                
                Podívej se na tohle! Je to staré oznámení o hledaných zločincích...\
                
                Vidíš? Na fotce jsou našé prarodiče s titulkem: 'Hledaní vrazi utekli z vězení!'\
                
                To nejsou naši prarodiče... jsme v nebezpečí! Musíme něco udělat!""");
        pridatKomunikaci("heslo", """
                Megan: Podívej se na tuhle knihu. Je jiná než ostatní. Všechny jsou zaprášené, ale tahle jako by ji někdo nedávno vzal do ruky.\
                
                Mezi listy je starý, zažloutlý papír... A na něm jen jediné slovo. Heslo? Ja vidim dvere, pojdme je otevrit
                 ___   ___ ___ ___  \s
                |_  | |_  |   |_  | \s
                 _| |_|  _| | |_| |_\s
                |_____|___|___|_____|
                                    \s""");

    }
    /**
     * Nastaví nový stav postavy podle situace.
     */
    public void nastavNovyStav() {
        if (this.getStav().equals("uvod")) {
            this.setStav("podezreni");
        } else if (this.getStav().equals("podezreni")) {
            this.setStav("krize");
        }
    }
    /**
     * Nastaví polohu sestry v určité místnosti.
     * @param poloha Nová poloha postavy.
     */
    public void setPoloha(Mistnost poloha) {
        this.poloha = poloha;
    }
    /**
     * Získá aktuální polohu sestry.
     * @return Poloha postavy.
     */
    public Mistnost getPoloha() {
        return poloha;
    }
}

