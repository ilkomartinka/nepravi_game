package hra;

import predmety.Predmet;
import svet.Mistnost;

import java.util.ArrayList;

/**
 * Třída reprezentující hráče ve hře.
 */
public class Hrac {
    private final ArrayList<Predmet> inventar;
    private Mistnost aktualniMistnost;

    /**
     * Konstruktor pro vytvoření hráče s prázdným inventářem.
     */
    public Hrac() {
        this.inventar = new ArrayList<>();
    }

    /**
     * Přidá předmět do inventáře. Pokud předmět již existuje, nebude přidán znovu.
     *
     * @param p Předmět, který má být přidán do inventáře.
     * @throws IllegalArgumentException Pokud je předmět null.
     */
    public void doplneniInventare(Predmet p) {
        if (p != null) {
            for (Predmet predmet : inventar) {
                if (predmet.getNazev().equals(p.getNazev())) {
                    return;
                }
            }
            inventar.add(p);
        } else {
            throw new IllegalArgumentException("Předmět nemůže být null.");
        }

    }


    /**
     * Odebere předmět z inventáře podle názvu.
     *
     * @param p předmět, který má být odebrán.
     * @throws IllegalArgumentException Pokud není předmět v inventáři.
     */
    public void odebratPredmet(Predmet p) {
        if (p != null) {
            inventar.remove(p);
        } else {
            System.out.println("Předmět " + p + " nebyl nalezen v inventáři.");
        }
    }



public Mistnost getAktualniMistnost() {
    return aktualniMistnost;
}

public void setAktualniMistnost(Mistnost aktualniMistnost) {
    this.aktualniMistnost = aktualniMistnost;
}

/**
 * Vrací seznam předmětů v inventáři ve formě řetězce.
 *
 * @return Seznam předmětů v inventáři jako řetězec.
 */
public String vypisInventar() {
    StringBuilder sb = new StringBuilder("Inventář: ");
    for (Predmet p : inventar) {
        sb.append("-").append(p.getNazev()).append(" ");
    }
    return sb.toString().trim();
}

/**
 * Zkontroluje, zda hráč předmět se zadaným názvem.
 *
 * @param p Název předmětu, který hledáme.
 * @return true, pokud hráč má tento předmět v inventáři, jinak false.
 */
public boolean maPredmet(String p) {
    for (Predmet predmet : inventar) {
        if (predmet.getNazev().equals(p)) {
            return true;
        }
    }
    return false;
}

/**
 * Vrací předmět podle názvu, pokud existuje v inventáři.
 *
 * @param nazev Název předmětu.
 * @return Předmět, pokud existuje, jinak null.
 * @throws IllegalArgumentException Pokud předmět není nalezen v inventáři.
 */
public Predmet getPredmet(String nazev) {
    for (Predmet predmet : inventar) {
        if (predmet.getNazev().equals(nazev)) {
            return predmet;
        }
    }
    throw new IllegalArgumentException("Předmět s názvem '" + nazev + "' nebyl nalezen v inventáři.");
}

public ArrayList<Predmet> getInventar() {
    return inventar;
}
}