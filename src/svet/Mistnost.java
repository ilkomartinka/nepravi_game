package svet;

import postavy.Postava;
import predmety.Predmet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Mistnost {
    private String nazev;
    private HashMap<String, Predmet> predmety; //<nazev predmetu, predmet>
    private HashSet<String> sousedniMistnosti;
    private boolean zamceno;
    private Predmet pomocnyPredmet; //k otevreni mistnosti
    private Postava postava;

    public Mistnost(String name) {
        this.nazev = name;
        this.sousedniMistnosti = new HashSet<>();
        this.predmety = new HashMap<>();
        this.zamceno = false;
        this.postava = null;
    }


    public void pridaniPredmetu(String nazevPredmetu, Predmet predmet) {
        predmety.put(nazevPredmetu, predmet);
    }

    public Predmet odebraniPredmetu() {
        if (!predmety.isEmpty()) {
            String key = predmety.keySet().iterator().next();
            return predmety.remove(key);
        }
        return null;
    }

    public boolean obsahujePredmet() {
        return !predmety.isEmpty();
    }


    public HashMap<String, Predmet> getPredmet() {
        return predmety;
    }

    public void setLock(boolean zamceno, Predmet PomocnyPredmet) {
        this.zamceno = zamceno;
        this.pomocnyPredmet = PomocnyPredmet;
    }

    public Predmet getPomocnyPredmet() {
        return pomocnyPredmet;
    }

    public boolean isZamceno() {
        return zamceno;
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


    public String getNazev() {
        return nazev;
    }

    public void pridaniMistnosti(String mistnost) {
        sousedniMistnosti.add(mistnost);
    }

    public HashSet<String> getSousedniMistnosti() {
        return sousedniMistnosti;
    }
    public void pridatPostavu(Postava postava) {
        if (this.postava == null) {
            this.postava = postava;
        } else {
            System.out.println("V této místnosti je již postava.");
        }
    }

    public Postava getPostava() {
        return postava;
    }
}
