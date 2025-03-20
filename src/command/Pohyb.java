package command;

import postavy.NepraviPrarodice;
import postavy.Postava;
import postavy.Segra;
import svet.Mistnost;

import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class Pohyb extends Command {
    private final Scanner sc = new Scanner(System.in);

    public Pohyb() {
    }

    @Override
    public String execute() {
        Mistnost aktualniMistnost = hrac.getAktualniMistnost();
        System.out.println("Ted jsi v mistnosti: " + aktualniMistnost.getNazev());
        System.out.println("Muzes jit do: " + String.join(", ", aktualniMistnost.getSousedniMistnosti()));
        System.out.print("Pujdu do: ");
        String volba = sc.next();
        if (aktualniMistnost.getSousedniMistnosti().contains(volba)) {
            Mistnost zvolenaMistnost = svet.getMapa().get(volba);
            if (zvolenaMistnost.isZamceno()) {
                System.out.println("Mistnost je zamcena, mas " + zvolenaMistnost.getPomocnyPredmet() + "? A/N");
                String odpoved = sc.next();
                switch (odpoved) {
                    case "A":
                        if(zvolenaMistnost.getNazev().equals("tajna") && hrac.maPredmet("klic")){//System.out.println("Tak ho použij");
                            zvolenaMistnost.setZamceno(false);
                            hrac.setAktualniMistnost(zvolenaMistnost);
                            break;
                        }else if (zvolenaMistnost.getNazev().equals("sklep")) {
                            System.out.println("Zadej heslo: ");
                            int heslo = sc.nextInt();
                            if (heslo == 1201) {
                                zvolenaMistnost.setZamceno(false);
                                hrac.setAktualniMistnost(zvolenaMistnost);
                                System.out.println(svet.najdiSegru().komunikace("sklep"));
                                //System.out.println(aktualniMistnost.getPostava().getJmeno() +" -> "+ aktualniMistnost.getPostava().getPopis());
                               // System.out.println("Rychle seznameni -> " + aktualniMistnost.getPostava());
                                //aktualniMistnost.getPostava().komunikace("uvod");
                            } else {
                                return "ŠPATNĚ, zkus znova :)";
                            }
                            break;
                        }
                    case "N":
                        System.out.println("Vrat se zpatky a zkus prohledat mistnosti");
                        break;
                    default:
                        return "pipipupu chybicka";
                }
            }else{
                hrac.setAktualniMistnost(zvolenaMistnost);
                svet.presunSegru(zvolenaMistnost);
            }
        }
        return "Ted se nachazis v -> " + hrac.getAktualniMistnost();
    }
}