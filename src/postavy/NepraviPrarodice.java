package postavy;

public class NepraviPrarodice extends Postava{
    public NepraviPrarodice() {
        super("Prarodiče", "... ale je na nich něco zvláštního.");
        pridatKomunikaci("uvod", "Prarodiče: No konečně... Ach, jak dlouho jsme na vás čekali! Jen pojďte dál, děti..." +
                "\nToto je váš pokoj. Rozložte si věci, za chvíli se vrátíme.");
        pridatKomunikaci("2", "Prarodiče: ");
        pridatKomunikaci("krize", "Prarodiče: Neměj strach, všechno bude v pořádku. Zůstaň s námi, odpočiň si...");
    }
}
