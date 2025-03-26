package predmety;
/**
 * Předmět reprezentující SIM kartu.
 */
public class SIMkarta extends Predmet {
    public SIMkarta() {
        super("SIMkarta");
    }

    @Override
    public String pouziti() {
            return "Vložil jsi SIM kartu do mobilu, teď je čas ho využít.";
        }
}
