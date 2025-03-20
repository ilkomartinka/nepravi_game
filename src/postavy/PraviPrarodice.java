package postavy;

public class PraviPrarodice extends Postava {
    public PraviPrarodice() {
        super("Praví prarodiče", "Tvá skutečná rodina, jsou uvezneni v sklepu ");
        pridatKomunikaci("uvod", "Prarodiče: Ahoj, miláčku. Konečně jsi tady. Už jsme tu dlouho. Aspon vy se musíte se dostat ven. ");
        pridatKomunikaci("vysvetleni", "Prarodiče: Zavřeli nás. Jsou to zločinci, kteří utekli z vězení a schováváji se před policií." +
                "\nZabili hodne lidi, ZAVOLEJTE POMOC, BEZTE");
    }
}

