package command;

import svet.Mistnost;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Třída {@code Pohyb} představuje pohyb hráče mezi místnostmi v textové hře.
 * Umožňuje hráči přesunout se do sousedních místností, kontroluje uzamčení místnosti
 * a požaduje odemknutí zamčené místnosti.
 *
 * @author Martina Ilko
 */
public class Pohyb extends Command {
    private final Scanner sc;

    /**
     * Konstruktor třídy {@code Pohyb}.
     * Vytvoří instanci příkazu pro pohyb.
     */
    public Pohyb() {
        sc = new Scanner(System.in);
    }

    /**
     * Provádí pohyb hráče mezi místnostmi. Pokud je místnost zamčená, hráč
     * musí splnit určité podmínky pro odemčení.
     *
     * @return Zprávu o výsledku pokusu o pohyb hráče, například:
     * - "Ted se nachazis v -> [název místnosti]"
     * - "Zustal jsi v mistnosti -> [název místnosti]"
     * - "Mistnost je zamcena..." (pokud je místnost zamčená)
     * - "ŠPATNĚ, zkus znova :)" (pokud heslo není správné)
     * - "Nesprávný formát hesla. Zadej číslo." (pokud uživatel zadá nesprávný formát hesla)
     */
    @Override
    public String execute() {
        try {
            Mistnost aktualniMistnost = hrac.getAktualniMistnost();
            System.out.println("Ted jsi v mistnosti: " + aktualniMistnost.getNazev());
            System.out.println("Muzes jit do: " + String.join(", ", aktualniMistnost.getSousedniMistnosti()));
            System.out.print("Pujdu do (zustat): ");
            String volba = sc.next();
            if(volba.equals("zustat")) {
                return "Zustal jsi v mistnosti -> " + aktualniMistnost.getNazev();
            }else{
                if (aktualniMistnost.getSousedniMistnosti().contains(volba)) {
                    Mistnost zvolenaMistnost = svet.getMapa().get(volba);
                    if (zvolenaMistnost.isZamceno()) {
                        System.out.println("Mistnost je zamcena, použij " + zvolenaMistnost.getPomocnyPredmet() + " k odemčení.");
                        if (zvolenaMistnost.getNazev().equals("sklep")) {
                            odemceniSklepu(zvolenaMistnost);
                        }
                    } else {
                        hrac.setAktualniMistnost(zvolenaMistnost);
                        svet.presunSegru(zvolenaMistnost);
                    }
                } else {
                    return "Neplatný vstup!Do této místnosti nelze vstoupit.";
                }
            }
            return "Ted se nacháziš v -> " + hrac.getAktualniMistnost();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (NoSuchElementException e) {
            return "Chyba při čtení vstupu. Zkuste to znovu.";
        } catch (Exception e) {
            return "Došlo k nečekané chybě: " + e.getMessage();
        }
    }

    private void odemceniSklepu(Mistnost zvolenaMistnost) {
        System.out.println("Zadej heslo: ");
        try {
            int heslo = sc.nextInt();
            if (heslo == 1201) {
                zvolenaMistnost.setZamceno(false);
                hrac.setAktualniMistnost(zvolenaMistnost);
                System.out.println(svet.najdiSegru().komunikace("sklep"));
                System.out.println("Rychlé seznámení -> " + svet.najdiPravePrarodice() + "\n" + svet.najdiPravePrarodice().komunikace("uvod"));
            }else {
                System.out.println( "ŠPATNĚ, zkus znova :)");
            }
        } catch (InputMismatchException e) {
           throw new InputMismatchException("Nesprávný formát hesla. Zadej číslo.");
        }
    }
}