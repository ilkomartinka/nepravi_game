package hra;

import predmety.Predmet;
import svet.Mistnost;

import java.util.ArrayList;

public class Hrac {
    private ArrayList<Predmet> inventar;
    private Mistnost aktualniMistnost;

    public Hrac() {
        this.inventar = new ArrayList<>();

    }

    public String doplneniInventare(Predmet p) {
        for (Predmet predmet : inventar) {
            if (predmet.getNazev().equals(p.getNazev())) {
                return "Tenhle predmet uz mas";
            }
        }
        inventar.add(p);
        return "Předmět přidan do inventaře";
    }
    public Predmet odebratPredmet(String nazev) {
        for(Predmet p : inventar){
            if(p.getNazev().equals(nazev)){
                inventar.remove(p);
                return p;
            }
        }
        return null;
    }


    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    public String getInventar() {
        StringBuilder sb = new StringBuilder("Inventář: ");
        for (Predmet p : inventar) {
            sb.append("-").append(p.getNazev()).append(" ");
        }
        return sb.toString().trim();
    }

    public boolean maPredmet(String p) {
        for (Predmet predmet : inventar) {
            if(predmet.getNazev().equals(p)){
                return true;
            }
        }
        return false;
    }

}
