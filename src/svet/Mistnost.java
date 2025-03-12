package svet;
import predmety.Predmet;
import java.util.Objects;
public class Mistnost {
    private String nazev;
    private Predmet predmet;

    public Mistnost(String name) {
        this.nazev = name;
    }
    @Override
    public String toString() {
        return nazev;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mistnost mistnost = (Mistnost) o;
        return Objects.equals(nazev, mistnost.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nazev);
    }

    public Predmet nastavPredmet(Predmet predmet){
        this.predmet = predmet;
        return predmet;
    }

    public Predmet odebratPredmet()    {
        if(predmet != null) {
            Predmet odebrany = predmet;
            predmet = null;
            return odebrany;
        }
        return null;
    }

    public boolean obsahujePredmet() {
        return predmet != null;
    }

    public Predmet getPredmet() {
        return predmet;
    }
    public String getNazev() {
        return nazev;
    }

}
