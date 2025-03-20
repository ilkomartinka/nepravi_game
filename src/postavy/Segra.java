package postavy;

import svet.Mistnost;

public class Segra extends Postava {
    private Mistnost poloha;

    public Segra() {
        super("Megan", "Tvoje sestra. Chodí všude za tebou, jako tvůj stín... akorát s větší pusou.");
        pridatKomunikaci("uvod", "Megan: těším se, až se seznámíme. Pokud děda vypadá jako na fotkách, asi mu budu muset půjčit hřeben");
        pridatKomunikaci("podezreni", "Megan: Něco tady nehraje... Všimnul sis jak se chovaji?");
        pridatKomunikaci("krize", "Megan: Musíme odsud vypadnout, jinak jsme v háji!");
        pridatKomunikaci("sklep", "Megan: KOUKEJ TADY NEKDO JE");
        pridatKomunikaci("odhaleni", "Megan: Koukej našla jsem na stole staré noviny..." +
                "\nPodívej se na tohle! Je to staré oznámení o hledaných zločincích..." +
                "\nVidíš? Na fotce jsou našé prarodiče s titulkem: 'Hledaní vrazi utekli z vězení!'" +
                "\nTo nejsou naši prarodiče... jsme v nebezpečí! Musíme něco udělat!");
        pridatKomunikaci("heslo", "Megan: Podívej se na tuhle knihu. Je jiná než ostatní. Všechny jsou zaprášené, ale tahle jako by ji někdo nedávno vzal do ruky." +
                "\nMezi listy je starý, zažloutlý papír... A na něm jen jediné slovo. Heslo? Ja vidim dvere, pojdme je otevrit" + "\n" +
                " ___   ___ ___ ___   \n" +
                "|_  | |_  |   |_  |  \n" +
                " _| |_|  _| | |_| |_ \n" +
                "|_____|___|___|_____|\n" +
                "                     ");

    }

    public void nastavNovyStav() {
        if (this.getStav().equals("uvod")) {
            this.setStav("podezreni");
        } else if (this.getStav().equals("podezreni")) {
            this.setStav("krize");
        }
    }

    public void setPoloha(Mistnost poloha) {
        this.poloha = poloha;
    }
}

