package postavy;

public class NepraviPrarodice extends Postava{
    public NepraviPrarodice() {
        super("Prarodiče", "Tvá prarodiče... ale je na nich něco zvláštního. Možná nejsou tím, kým se zdají být.");
        pridatKomunikaci("úvod", "Prarodiče: Miláčku, co tady děláš tak pozdě? Pojď si odpočinout, ráno bude líp...");
        pridatKomunikaci("krize", "Prarodiče: Neměj strach, všechno bude v pořádku. Zůstaň s námi, odpočiň si...");
    }
}
