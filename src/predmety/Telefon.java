package predmety;

public class Telefon extends Predmet {

    public Telefon() {
        super("telefon");
    }

    @Override
    public String pouziti() {
        System.exit(0);
        return "Volame pomoc!!!Buď však opatrný, prarodiče si mohou všimnout, že telefonuješ.";
    }
}
