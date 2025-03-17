package postavy;

public class PraviPrarodice extends Postava {
    public PraviPrarodice() {
        super("Praví prarodiče", " ");//Tvá skutečná rodina, která kdysi zmizela za zvláštních okolností.
       // pridatKomunikaci("uvod", "Prarodiče: Ahoj, miláčku. Konečně jsi tady. Už jsme tu dlouho. Aspon ty se musíš se dostat ven. ");
        pridatKomunikaci("napoveda", "To, co ti říkají ti lidé, není pravda. SIM karta je v koupelně.");
        pridatKomunikaci("vysvetleni", "Prarodiče: Zavřeli nás. Jsou to zločinci, kteří utekli z vězení a schováváji se před policií. Zabili hodne lidi, ZAVOLEJTE POMOC");
    }
}

