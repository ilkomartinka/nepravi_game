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
    private final Scanner sc = new Scanner(System.in);
    /**
     * Konstruktor třídy {@code Pohyb}.
     * Vytvoří instanci příkazu pro pohyb.
     */
    public Pohyb() {
    }
    /**
     * Provádí pohyb hráče mezi místnostmi. Pokud je místnost zamčená, hráč
     * musí splnit určité podmínky pro odemčení.
     *
     * @return Zprávu o výsledku pokusu o pohyb hráče, například:
     *         - "Ted se nachazis v -> [název místnosti]"
     *         - "Mistnost je zamcena..." (pokud je místnost zamčená)
     *         - "Neplatná volba, prosím zadej 'A' nebo 'N'." (pokud odpověď není A nebo N)
     *         - "ŠPATNĚ, zkus znova :)" (pokud heslo není správné)
     *         - "Nesprávný formát hesla. Zadej číslo." (pokud uživatel zadá nesprávný formát hesla)
     */
    @Override
    public String execute() {
        try {
            Mistnost aktualniMistnost = hrac.getAktualniMistnost();
            System.out.println("Ted jsi v mistnosti: " + aktualniMistnost.getNazev());
            System.out.println("Muzes jit do: " + String.join(", ", aktualniMistnost.getSousedniMistnosti()));
            System.out.print("Pujdu do: ");
            String volba = sc.next();
            if (aktualniMistnost.getSousedniMistnosti().contains(volba)) {
                Mistnost zvolenaMistnost = svet.getMapa().get(volba);
                // Pokud je místnost zamčená, požaduje se od hráče odemknutí
                if (zvolenaMistnost.isZamceno()) {
                    System.out.println("Mistnost je zamcena, mas " + zvolenaMistnost.getPomocnyPredmet() + "? A/N");
                    String odpoved = sc.next();
                    switch (odpoved.toLowerCase().trim()) {
                        case "a":
                            if (zvolenaMistnost.getNazev().equals("tajna") && hrac.maPredmet("klic")) {
                                hrac.setAktualniMistnost(zvolenaMistnost);
                                break;
                            } else if (zvolenaMistnost.getNazev().equals("sklep")) {
                                System.out.println("Zadej heslo: ");
                                try {
                                    int heslo = sc.nextInt();
                                    if (heslo == 1201) {
                                        zvolenaMistnost.setZamceno(false);
                                        hrac.setAktualniMistnost(zvolenaMistnost);
                                        System.out.println(svet.najdiSegru().komunikace("sklep"));
                                        System.out.println("Rychlé seznámení -> " + svet.najdiPravePrarodice() + "\n" + svet.najdiPravePrarodice().komunikace("uvod"));
                                    } else {
                                        return "ŠPATNĚ, zkus znova :)";
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    return "Nesprávný formát hesla. Zadej číslo.";
                                }
                            }
                            break;
                        case "n":
                            System.out.println("Vrat se zpatky a zkus prohledat mistnosti");
                            break;
                        default:
                            return "Neplatná volba, prosím zadej 'A' nebo 'N'.";
                    }
                } else {
                    hrac.setAktualniMistnost(zvolenaMistnost);
                    svet.presunSegru(zvolenaMistnost);
                }
            }
            return "Ted se nachazis v -> " + hrac.getAktualniMistnost();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (NoSuchElementException e) {
            return "Chyba při čtení vstupu. Zkuste to znovu.";
        } catch (Exception e) {
            return "Došlo k nečekané chybě: " + e.getMessage();
        }
    }
}