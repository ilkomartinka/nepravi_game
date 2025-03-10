package svet;
import predmety.Predmet;

import java.util.Objects;
public class Mistnost {
    private String nazev;
    private Predmet predmet;
    //private ArrayList<Postava> postavy;

    public Mistnost(String name) {
        this.nazev = name;
    }

    public String getNazev() {
        return nazev;
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

    /*public ArrayList<Postava> getPostavy() {
        return postavy;
    }*/
    public void nastavPredmet(Predmet p){
        this.predmet = p;
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

}
