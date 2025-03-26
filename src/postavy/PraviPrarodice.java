package postavy;
/**
 * Třída představující skutečné prarodiče hráče.
 */
public class PraviPrarodice extends Postava {
    /**
     * Konstruktor pro vytvoření skutečných prarodičů.
     */
    public PraviPrarodice() {
        super("Praví prarodiče", "Tvá skutečná rodina, jsou uvezneni v sklepu.");
        pridatKomunikaci("uvod", """
                Prarodiče: Ahoj, miláčku. Konečně jsi tady. Už jsme tu dlouho. Aspon vy se musíte dostat ven.\
                
                Prarodiče: Zavřeli nás. Jsou to zločinci, kteří utekli z vězení a schováváji se před policií.\
                
                Zabili hodne lidi... Najdete tady mobil a když najdete SIMkartu ZAVOLEJTE POMOC. BĚŽTE\s""");
    }
}