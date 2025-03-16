package command;

import svet.Mistnost;

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
                        System.out.println("Tak to pouzij");
                        break;
                    case "N":
                        System.out.println("Nedostanes se sem");
                        break;
                    default:
                        System.out.println("Nechapu co po mne chces");
                }
            }
            hrac.setAktualniMistnost(zvolenaMistnost);
        } else {
            return "Chybicka";
        }
        return "Ted se nachazis v -> " + hrac.getAktualniMistnost();
    }
}
