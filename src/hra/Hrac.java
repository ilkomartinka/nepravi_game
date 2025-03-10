package hra;

import predmety.Predmet;
import svet.Mistnost;

import java.util.ArrayList;

public class Hrac {
    private ArrayList<Predmet> inventar;
    private Mistnost aktualniMistnost;

    public Hrac() {
        this.inventar = new ArrayList<>();
        this.aktualniMistnost = new Mistnost("detska");
    }

    public String pridatPredmet(Predmet p) {
        if(!inventar.contains(p)){
            inventar.add(p);
            return "Předmět přidan do inventaře";
        }
        return "Tenhle predmet uz mas";
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

    public ArrayList<Predmet> getInventar() {
        if(inventar.isEmpty()){
            System.out.println("Tvůj inventář je prázdný.");
        }else{
            System.out.println("Inventář: ");
            for(Predmet p : inventar){
                System.out.println(" - " + p.getNazev());
            }
        }
        return inventar;
    }
    private boolean obsahujePredmet(Predmet p) {
        return inventar.contains(p);
    }

}
