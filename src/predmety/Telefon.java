package predmety;

public class Telefon extends Predmet {

    public Telefon() {
        super("telefon");
    }

    @Override
    public String pouziti() {
        return "Volame pomoc!!!Buď však opatrný, prarodiče si mohou všimnout, že telefonuješ.";
    }
}
