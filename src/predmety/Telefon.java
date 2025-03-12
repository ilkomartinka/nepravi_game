package predmety;

import hra.Hrac;

public class Telefon extends Predmet{
    private boolean finguje = false;

    public Telefon() {
        super("telefon");
    }

    @Override
    public String pouziti() {
        if(finguje){
            return "Volame pomoc!!!Buď však opatrný, prarodiče si mohou všimnout, že telefonuješ.";
        }else{
            return "Nejdriv ho musis opravit";
        }
    }
}
